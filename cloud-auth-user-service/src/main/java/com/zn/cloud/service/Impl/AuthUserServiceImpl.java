package com.zn.cloud.service.Impl;

import com.zn.cloud.FeignClient.PaymentServiceClient;
import com.zn.cloud.entity.TUser;
import com.zn.cloud.mapper.TUserMapper;
import com.zn.cloud.service.AuthUserService;
import com.zn.cloud.util.BPwdEncoderUtil;
import com.zn.cloud.util.UserLoginException;
import com.zn.springCloud.entities.CommentResule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private TUserMapper userMapper;



    @Autowired
    private PaymentServiceClient paymentServiceClient;
    @Override
    public CommentResule register(TUser user) {
        int value= userMapper.create(user);
        //userRepository.insertUser(user.getUsername(), user.getPassword());
        return new CommentResule(200,"注册成功",null);
    }




}
