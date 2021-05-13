package com.zn.cloud.dao;

import lombok.Data;

@Data
public class JWTReq {
    private String authorization;
    private String type;
    private String username;
    private String password;
}
