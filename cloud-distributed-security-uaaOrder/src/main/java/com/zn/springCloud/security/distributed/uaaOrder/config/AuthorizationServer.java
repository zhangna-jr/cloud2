package com.zn.springCloud.security.distributed.uaaOrder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {


    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 配置支持的客户端的详情服务，并不是所有的客户端都支持。
     * 客户端详情信息在这里初始化，可把客户端详情信息写死在这里或者通过数据库存储调取详情信息
     *
     * @author: zhangna
     * @date: 2021/4/6 17:27
     *
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()           //使用内存存储客户端信息
                .withClient("")   //client_id，用来标识客户的ID
                .secret()         //客户端安全码，密钥
                .resourceIds("")
                .authorizedGrantTypes()   //该client允许的授权类型，默认为空
                .scopes("all")  //用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部访问权限
                .autoApprove(false)
                .redirectUris()   //验证回调地址

    }
}
