package com.zn.springCloud.security.distributed.uaa.entity;


import lombok.Data;


/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: 权限表
 * @author: zhangna
 * @date: 2021/7/26 19:44
 *
 */
@Data
public class TPermission {

    private String id;
    private String code;//权限标识符
    private String description;//描述
    private String url;//请求地址

}
