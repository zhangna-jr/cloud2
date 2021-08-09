package com.zn.springCloud.security.distributed.uaaOrder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration

//第二种授权方式
@EnableGlobalMethodSecurity(prePostEnabled = true)   //开启controller中注解验证授权方式（@PreAuthorize）
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    //3、配置安全拦截机制
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   //关闭CSRF
                .authorizeRequests()
                //.antMatchers("/user/foo").hasAuthority("p1")    //第一种授权方式****,当请求/user/foo时，必须有p1的权限
                //.antMatchers("/user/register","/user/login").permitAll()    //不拦截"/user/register","/user/login"
                .antMatchers("/r/**").authenticated()   //其余全部拦截验证
                .anyRequest().permitAll();  //除了/r/**，其他都可访问
    }
}
