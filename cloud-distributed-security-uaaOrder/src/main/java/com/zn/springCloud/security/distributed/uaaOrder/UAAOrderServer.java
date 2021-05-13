package com.zn.springCloud.security.distributed.uaaOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class UAAOrderServer {

    public static void main(String[] args) {
        SpringApplication.run(UAAOrderServer.class,args);
    }
}
