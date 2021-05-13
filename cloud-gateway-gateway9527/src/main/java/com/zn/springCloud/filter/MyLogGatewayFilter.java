package com.zn.springCloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: 过滤器，在路由转发之前执行
 * @author: zhangna
 * @date: 2021/1/28 9:17
 *
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            System.out.println("------------------->非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 执行顺序，return数值越小代表越先执行
     * @author: zhangna
     * @date: 2021/1/28 9:17
     *
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
