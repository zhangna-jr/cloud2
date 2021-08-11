package com.zn.cloud.service.Impl;


import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zn.cloud.entity.TPermission;
import com.zn.cloud.entity.TUser;
import com.zn.cloud.mapper.TPermissionMapper;
import com.zn.cloud.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
    private TPermissionMapper tPermissionMapper;

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser tUser = tUserMapper.searchUser(username);
        List<TPermission> tPermissions = tPermissionMapper.searchPermissions(tUser.getId());
        ArrayList<String> codes=new ArrayList<String>();
        for (int i = 0;i<tPermissions.size();i++) {
            codes.add(tPermissions.get(i).getCode());
        }
        String[] strings = new String[codes.size()];
        if (codes.size()>0){
            codes.toArray(strings);
        }
        //String s = JSON.toJSONString(tUser);
        //User byUsername = userRepository.findByUsername(username);
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(tUser.getUserName())
                .password(tUser.getUserPassword()).authorities(strings).build();
        //return byUsername;
        return userDetails;
    }
}
