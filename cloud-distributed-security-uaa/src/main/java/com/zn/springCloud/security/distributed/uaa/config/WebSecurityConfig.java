package com.zn.springCloud.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration

//第二种授权方式
@EnableGlobalMethodSecurity(prePostEnabled = true)   //开启controller中注解验证授权方式（@PreAuthorize）
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    //配置认证管理器
    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }



    //2、密码编辑器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //3、配置安全拦截机制
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   //关闭CSRF
                .authorizeRequests()
                .antMatchers("/user/foo").hasAuthority("p1")    //第一种授权方式****,当请求/user/foo时，必须有p1的权限
                .antMatchers("/user/register","/user/login").permitAll()    //不拦截"/user/register","/user/login"
                .anyRequest().authenticated()   //其余全部拦截验证
                .and()
                .formLogin();  //允许表单提交
    }
}
