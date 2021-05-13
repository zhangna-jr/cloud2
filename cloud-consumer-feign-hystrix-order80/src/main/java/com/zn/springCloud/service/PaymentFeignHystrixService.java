package com.zn.springCloud.service;

import com.zn.springCloud.entities.CommentResule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-payment-hystrix-service")
public interface PaymentFeignHystrixService {

    @RequestMapping(value = "/paymentHystrix/paymentInfo_OK")
    public CommentResule paymentInfo_OK();

    @RequestMapping(value = "/paymentHystrix/paymentInfo_timeout")
    public CommentResule paymentInfo_Timeout();
}
