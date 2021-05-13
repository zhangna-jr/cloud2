package com.zn.springCloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gatewayConfiguration {


    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 配置路由
     * desc1:path_route(路由ID)
     * desc2:当请求地址为http://localhost:9527/guonei时，转发到http://news.baidu.com/guonei
     *
     * 路由的两种配置方式：1、application.yml中配置。2、此配置类为第二种配置方式
     * @author: zhangna
     * @date: 2021/1/26 11:11
     *
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route",
                r -> r.path("/guonei").
                        uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator routesguoji(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_guoji",
                r -> r.path("/guoji").
                        uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
