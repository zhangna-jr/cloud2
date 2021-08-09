package com.zn.springCloud.security.distributed.uaa.entity;

import lombok.Data;


/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: 用户角色表
 * @author: zhangna
 * @date: 2021/7/26 19:42
 *
 */
@Data
public class TUserRole {

    private String userId;
    private String roleId;
    private String createTime;
    private String createror;

}
