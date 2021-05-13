package com.zn.springCloud.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import com.zn.springCloud.entities.SdkEntity.Student;
import com.zn.springCloud.entities.SdkEntity.User;
import com.zn.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.SignAddTest;

import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "cloudTest")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "create")
    public CommentResule create(@RequestBody Payment payment) throws Exception {
        System.out.println("提供者新增");
        CommentResule commentResule = paymentService.create(payment);
        return commentResule;
    }

    @RequestMapping(value = "searceData")
    public CommentResule searceData(@RequestBody Payment payment){
        System.out.println("提供查询");
        CommentResule commentResule = paymentService.searceData(payment);
        return commentResule;
    }

    @RequestMapping(value = "discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services) {
            log.info("*********element*****"+element);
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for (ServiceInstance instance:instances) {
                log.info("****instance****"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            }
        }
        return discoveryClient;
    }

    @RequestMapping(value = "payment/getLB")
    public Object getLB(@RequestBody Payment payment){
        return serverPort;
    }

    @RequestMapping(value = "payment/feignTimeOut")
    public CommentResule feignTimeOut(){
        System.out.println("-----------8001进来了-------------");
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CommentResule(0000,"查询成功",serverPort+"---");
    }

}
