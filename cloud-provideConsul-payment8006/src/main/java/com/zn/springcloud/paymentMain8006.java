package com.zn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class paymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8006.class,args);
    }
}
