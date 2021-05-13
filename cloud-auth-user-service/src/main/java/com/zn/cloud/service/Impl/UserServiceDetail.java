package com.zn.cloud.service.Impl;


import com.zn.cloud.config.UserRepository;
import com.zn.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: 查询用户信息
 * 1、UserDetailsService：获取用户信息工具接口
 * 2、spring Security认证流程先由UsernamePasswordAuthenticationFilter过滤器拦截，由DaoAuthenticationProvide类实现用户查询，密码校验功能。
 * 3、若在（2）基础上想要修改用户查询功能可自定义类（UserServiceDetail）实现UserDetailsService接口。
 * @author: zhangna
 * @date: 2021/4/6 10:10
 *
 */
@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepository.findByUsername(username);
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(byUsername.getUsername())
                .password(byUsername.getPassword()).authorities(byUsername.getAuthorities()).build();
        //return byUsername;
        return userDetails;
    }
}
