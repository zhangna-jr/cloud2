package com.zn.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.dhcc","com.zn.springCloud"})
@EnableFeignClients(basePackages = "com.dhcc")
@EnableEurekaClient
//@EnableDiscoveryClient
public class paymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8001.class,args);
    }
}
