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
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
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
                //client_credentials客户端模式，authorization_code授权码模式，password密码模式，implicit简单模式
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token")  //该client允许的授权类型
                .scopes("all")  //允许的授权范围
                .autoApprove(false)  //false 跳转到授权页面
                .redirectUris("http://www.baidu.com");
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

    //设置授权码模式授权码如何存取，暂  时采用内存方式,上面通过@Autowired注入
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }
    /**
     * @Description:  令牌的是授权类型
     * 1、authenticationManager是认证管理器，当选择密码授权类型时需要注入AuthenticationManager对象
     * 2、userDetailService,当选择密码授权类型时要配，当设置这个属性之后，“refresh_token”刷新令牌授权类型模式流程中会包含检查，确保此账号是否有效
     * 3、authorizationCodeServices，设置授权码服务，主要用于authorization_code授权码类型
     * @Description: 令牌访问端点有哪些
     * 1、/oauth/authorize:授权端点
     * 2、/oauth/token:令牌端点
     * 3、/oauth/confirm_access:用户确认授权提交端点
     * 4、/oauth/error:授权服务错误信息端点
     * 5、/oauth/check_token:用于资源服务访问的令牌解析端点
     * 6、/oauth/token_key:提供公有密钥端点，如果使用jwt令牌
     * @date: 2021/8/8 11:15
     *
     */
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
