package com.zn.springCloud.mapper;

import com.zn.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDaoMapper {
    int create(@Param("payment") Payment payment);
    Payment selectById(@Param("id") Long id);
}
