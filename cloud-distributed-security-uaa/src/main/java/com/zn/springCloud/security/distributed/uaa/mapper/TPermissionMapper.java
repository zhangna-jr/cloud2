package com.zn.springCloud.security.distributed.uaa.mapper;


import com.zn.springCloud.security.distributed.uaa.entity.TPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TPermissionMapper {
    List<TPermission> searchPermissions(@Param("userId") String userId);
}
