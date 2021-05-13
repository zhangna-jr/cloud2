package com.zn.springCloud.controller;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import com.zn.springCloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "paymentHystrix")
public class paymentHystrixController {


    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @RequestMapping(value = "paymentInfo_OK")
    public CommentResule paymentInfo_OK(){
        System.out.println("-------------paymentInfo_OK-------------");
        return hystrixPaymentService.paymentInfo_OK();
    }

    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 服务降级
     * @author: zhangna
     * @date: 2021/1/15 16:57
     *
     */
    @RequestMapping(value = "paymentInfo_timeout")
    public CommentResule paymentInfo_timeout(){
        System.out.println("-----------------paymentInfo_timeout-----------------");
        return hystrixPaymentService.paymentInfo_timeout();
    }

    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 服务熔断
     * @author: zhangna
     * @date: 2021/1/15 16:57
     *
     */

    @RequestMapping(value = "paymentInfo_circultBreaker")
    public CommentResule paymentInfo_circultBreaker(@RequestBody Payment payment) throws Exception {
        System.out.println("-----------paymentInfo_circultBreaker---------------");
        return hystrixPaymentService.paymentInfo_circultBreaker(payment);
    }
}
