package com.zn.springCloud.security.distributed.uaa.entity;


import lombok.Data;

@Data

public class TUser {

    private String id;
    private String userName;
    private String userPassword;
    private String fullname;
    private String mobile;

}
