package com.zn.cloud.FeignClient;


import com.zn.springCloud.entities.CommentResule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentServiceClient {

    @RequestMapping(value =  "/cloudTest/payment/feignTimeOut")
    public CommentResule feignTimeOut();
}
