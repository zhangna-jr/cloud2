package com.zn.cloud.service.Impl;

import com.zn.cloud.FeignClient.AuthServiceClient;
import com.zn.cloud.FeignClient.PaymentServiceClient;
import com.zn.cloud.config.UserRepository;
import com.zn.cloud.dao.JWT;
import com.zn.cloud.dao.JWTReq;
import com.zn.cloud.dao.UserLoginDTO;
import com.zn.cloud.entity.User;
import com.zn.cloud.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthServiceClient client;

    @Autowired
    private PaymentServiceClient paymentServiceClient;
    @Override
    public CommentResule register(User user) {
        int value= userMapper.create(user);
        //userRepository.insertUser(user.getUsername(), user.getPassword());
        return new CommentResule(200,"注册成功",null);
    }

    @Override
    public UserLoginDTO login(String username,String password) {
        // 查询数据库
        User userOne = userRepository.findByUsername(username);
        if (userOne == null) {
            throw new UserLoginException("error username");
        }

        if(!BPwdEncoderUtil.matches(password,userOne.getPassword())){
            throw new UserLoginException("error password");
        }
        String pwd = new BCryptPasswordEncoder().encode(password);
        //paymentServiceClient.feignTimeOut();
        // 从auth-service获取JWT
        JWT jwt = client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, pwd);
        //JWT jwt = client.getToken(jwtReq);
        if(jwt == null){
            throw new UserLoginException("error internal");
        }

        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(userOne);
        return userLoginDTO;
    }


}
