package com.zn.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class consumerFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(consumerFeignHystrixMain80.class,args);
    }
}
