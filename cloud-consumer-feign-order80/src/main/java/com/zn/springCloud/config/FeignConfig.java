package com.zn.springCloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: OpenFeign日志增强配置
 * @author: zhangna
 * @date: 2021/1/14 10:04
 *
 */
@Configuration
public class FeignConfig {


    /*
    feign的日志级别分为四类
    NONE：默认的，不显示任何日志
    BASIC：仅记录请求方法，URL，响应状态码，执行时间
    HEADERS：除了BASIC之外还有请求和响应的头信息
    FULL：除了HEADERS之外，还有请求和响应的正文及元数据
    */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
