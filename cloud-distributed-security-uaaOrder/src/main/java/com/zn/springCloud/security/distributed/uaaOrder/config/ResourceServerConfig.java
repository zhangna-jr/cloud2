package com.zn.springCloud.security.distributed.uaaOrder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer  //此注解表明此配置类为资源服务配置类
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "res1";  //资源ID，与授权服务中客户端详情服务配置中的资源服务相对应

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)  //资源ID
                .tokenServices(tokenServices())  // 验证令牌的服务
                .stateless(true);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")   //所有访问的scope都有all,授权服务配置中客户端详情配置中scope必须为all
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);   //不用记录session
    }

    @Bean
    public ResourceServerTokenServices tokenServices(){
        //远程访问授权服务令牌
        RemoteTokenServices services = new RemoteTokenServices();
        services.setCheckTokenEndpointUrl("http://localhost:53020/oauth/check_token");  //授权服务的check_token,授权服务中令牌访问端点安全策略开放了check_token
        services.setClientId("c1");
        services.setClientSecret("secret");
        return services;
    }


}
