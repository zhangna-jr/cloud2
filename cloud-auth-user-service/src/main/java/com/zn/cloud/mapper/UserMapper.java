package com.zn.cloud.mapper;

import com.zn.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int create(@Param("user")User user);
}
