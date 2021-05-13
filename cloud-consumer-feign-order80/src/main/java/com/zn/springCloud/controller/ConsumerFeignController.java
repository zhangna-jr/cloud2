package com.zn.springCloud.controller;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import com.zn.springCloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "consumerFeign")
@Slf4j
public class ConsumerFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/cloudTest/searceData")
    public CommentResule searceData(@RequestBody Payment payment){
        CommentResule result = paymentFeignService.searceData(payment);
        return result;
    }

    @RequestMapping(value = "payment/feignTimeOut")
    public CommentResule feignTimeOut(){
        CommentResule result = paymentFeignService.feignTimeOut();
        return result;
    }
}
