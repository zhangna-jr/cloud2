package com.zn.springCloud.controller;

import com.google.inject.internal.cglib.proxy.$FixedValue;
import com.zn.springCloud.LB.LoadBalance;
import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "consumer")
public class ConsumerController {

    @Resource
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalance loadBalance;

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @PostMapping(value = "payment/creat")
    public CommentResule creat(@RequestBody Payment payment){
        System.out.println("消费者新增");
        return restTemplate.postForObject(PAYMENT_URL+"/cloudTest/create",payment,CommentResule.class);
    }

    @PostMapping(value = "payment/searceData")
    public CommentResule searceData(@RequestBody Payment payment){
        System.out.println("消费查询");
        return restTemplate.postForObject(PAYMENT_URL+"/cloudTest/searceData",payment,CommentResule.class);
    }

    @PostMapping(value = "payment/searceDataEntity")
    public CommentResule searceDataEntity(@RequestBody Payment payment){
        ResponseEntity<CommentResule> result = restTemplate.postForEntity(PAYMENT_URL+"/cloudTest/searceData",payment,CommentResule.class);
        return result.getBody();
    }

    @RequestMapping(value = "payment/getLB")
    public Object getLB(@RequestBody Payment payment){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if(instances == null ||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.serviceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.postForObject(uri+"/cloudTest/payment/getLB",payment,Object.class);
    }
}
