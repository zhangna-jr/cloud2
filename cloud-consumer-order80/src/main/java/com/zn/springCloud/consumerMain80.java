package com.zn.springCloud;

import com.zn.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-payment-service" ,configuration = MySelfRule.class)   //自定义负载均衡算法
public class consumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(consumerMain80.class,args);
    }
}
