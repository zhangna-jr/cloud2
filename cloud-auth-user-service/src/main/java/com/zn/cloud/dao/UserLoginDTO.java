package com.zn.cloud.dao;

import com.zn.cloud.entity.User;
import lombok.Data;

@Data
public class UserLoginDTO {

    private JWT jwt;
    private User user;
}
