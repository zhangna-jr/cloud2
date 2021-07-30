package com.zn.cloud.service;

import com.zn.cloud.entity.TUser;
import com.zn.springCloud.entities.CommentResule;

public interface AuthUserService {
    CommentResule register(TUser user);

}
