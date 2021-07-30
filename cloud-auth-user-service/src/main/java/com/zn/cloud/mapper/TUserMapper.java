package com.zn.cloud.mapper;


import com.zn.cloud.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TUserMapper {

    TUser searchUser(@Param("username")String username);
}
