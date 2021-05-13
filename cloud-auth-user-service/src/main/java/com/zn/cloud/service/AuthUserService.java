package com.zn.cloud.service;

import com.zn.cloud.dao.UserLoginDTO;
import com.zn.cloud.entity.User;
import com.zn.springCloud.entities.CommentResule;

public interface AuthUserService {
    CommentResule register(User user);

    UserLoginDTO login(String username,String password);
}
