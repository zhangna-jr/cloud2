package com.zn.springCloud.security.distributed.uaa.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "uaa123"; //对称密钥，此密钥应与资源服务的对称密钥保持一致
    /*
     * description:令牌存储策略
     * @param:
     * @return:
     * @author: zhangna
     * @date: 2021/8/1
     */
    @Bean
    public TokenStore tokenStore(){
        //内存方式，生成普通令牌
        //return new InMemoryTokenStore();

        //JWT令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(SIGNING_KEY); //对称密钥，资源服务器使用该密钥来验证
        return jwtAccessTokenConverter;
    }
}
