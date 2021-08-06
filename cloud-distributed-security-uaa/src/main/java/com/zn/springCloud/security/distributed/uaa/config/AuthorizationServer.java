package com.zn.springCloud.security.distributed.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;


/*
 * description:授权服务配置
 * 1、配置客户端详情信息（首先需要配置哪些客户端可以访问，并不是所有的客户端都能访问的）
 * 2、配置令牌访问端点即url及令牌管理服务
 * 3、配置访问令牌的安全策略
 * @param:
 * @return:
 * @author: zhangna
 * @date: 2021/8/1
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    //1、配置客户端详情信息服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //暂时使用内存方式
        clients.inMemory()
                .withClient("c1")  //client_id：客户端id
                .secret(new BCryptPasswordEncoder().encode("secret"))  //客户端密钥
                .resourceIds("res1")  //客户端可以访问的资源列表
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token")  //该client允许的授权类型
                .scopes("all")  //允许的授权范围
                .autoApprove(false)  //false 跳转到授权页面
                .redirectUris("http:www.baidu.com");
    }

    //2.1、令牌管理服务
    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);  //客户端信息服务
        services.setSupportRefreshToken(true);  //是否产生刷新令牌
        services.setTokenStore(tokenStore);   //令牌存储策略
        services.setAccessTokenValiditySeconds(7200);   //令牌默认有效期
        services.setRefreshTokenValiditySeconds(259200);  //刷新令牌默认有效期3天
        return services;
    }

    //2.2、令牌访问端点
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)  //密码模式需要
                .authorizationCodeServices(authorizationCodeServices)  //授权码模式需要
                .tokenServices(tokenServices())  //令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);   //允许post提交
    }

    //3、令牌访问端点安全策略
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")   // /oauth/token_key公开
                .checkTokenAccess("permitAll()")   // 检测（/oauth/check_token）公开
                .allowFormAuthenticationForClients();  //表单认证，申请令牌
    }

}
