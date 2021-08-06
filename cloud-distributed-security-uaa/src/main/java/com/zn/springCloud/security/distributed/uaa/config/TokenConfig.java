package com.zn.springCloud.security.distributed.uaa.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenConfig {

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
        return new InMemoryTokenStore();
    }
}
