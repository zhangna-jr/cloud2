package com.zn.springCloud.controller;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import com.zn.springCloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "cloudTest")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "create")
    public CommentResule create(@RequestBody Payment payment) throws Exception {
        CommentResule commentResule = paymentService.create(payment);
        return commentResule;
    }

    @RequestMapping(value = "searceData")
    public CommentResule searceData(@RequestBody Payment payment){
        System.out.println("提供查询");
        CommentResule commentResule = paymentService.searceData(payment);
        return commentResule;
    }

    @RequestMapping(value = "payment/getLB")
    public Object getLB(){
        return serverPort;
    }

    @RequestMapping(value = "payment/feignTimeOut")
    public CommentResule feignTimeOut(){
        System.out.println("------------------8002进来了------------");
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CommentResule(0000,"查询成功",serverPort+"---");
    }



}
