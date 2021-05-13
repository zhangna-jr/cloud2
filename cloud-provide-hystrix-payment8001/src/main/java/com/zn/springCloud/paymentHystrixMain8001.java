package com.zn.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker    //hystrix服务降级注解
public class paymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(paymentHystrixMain8001.class,args);
    }
}
