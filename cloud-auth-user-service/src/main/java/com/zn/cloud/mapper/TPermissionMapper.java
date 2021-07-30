package com.zn.cloud.mapper;


import com.zn.cloud.entity.TPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TPermissionMapper {
    List<TPermission> searchPermissions(@Param("userId") String userId);
}
