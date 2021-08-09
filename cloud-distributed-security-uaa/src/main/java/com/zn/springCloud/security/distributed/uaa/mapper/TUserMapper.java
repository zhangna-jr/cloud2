package com.zn.springCloud.security.distributed.uaa.mapper;


import com.zn.springCloud.security.distributed.uaa.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TUserMapper {

    TUser searchUser(@Param("username") String username);

    int create(@Param("user") TUser user);
}
