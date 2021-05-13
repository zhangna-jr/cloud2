package com.zn.springCloud.service;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping(value = "/cloudTest/searceData")
    public CommentResule searceData(@RequestBody Payment payment);

    @RequestMapping(value = "/cloudTest/payment/feignTimeOut")
    public CommentResule feignTimeOut();
}
