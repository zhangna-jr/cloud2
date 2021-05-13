package com.zn.springCloud.controller;


import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "ConsumerFeignHystrix")
public class ConsumerFeignHystrixController {

    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;

    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description:
     * @author: zhangna
     * @date: 2021/1/18 9:30
     *
     */
    @RequestMapping(value = "paymentInfo_OK")
    public CommentResule paymentInfo_OK(){
        return paymentFeignHystrixService.paymentInfo_OK();
    }


    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 服务降级
     * @author: zhangna
     * @date: 2021/1/18 9:31
     *
     */
    @RequestMapping(value = "paymentInfo_Timeout")
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
    })
    public CommentResule paymentInfo_Timeout(){
        return paymentFeignHystrixService.paymentInfo_Timeout();
    }
    public CommentResule paymentInfo_timeoutHandler(){
        return new CommentResule(0000,"consumerFeignHystrix系统异常，请10秒钟之后再试",null);
    }



}
