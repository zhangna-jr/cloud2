package com.zn.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: springcloud配置中心的server端
 * @author: zhangna
 * @date: 2021/1/29 16:44
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class,args);
    }
}
