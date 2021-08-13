package com.zn.springCloud.configuration;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    //@LoadBalanced   //此处注释掉负载均衡是因为ConsumerController中getLB()自写了负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
