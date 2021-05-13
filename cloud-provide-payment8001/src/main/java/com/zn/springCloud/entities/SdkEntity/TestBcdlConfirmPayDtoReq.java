package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TestBcdlConfirmPayDtoReq {

    @NotBlank(message = "借方账号不能为空")
    private String Actno;//借方账号
    @NotBlank(message = "贷方账号不能为空")
    private String Coractno;//贷方账号
    @NotBlank(message = "交易描述不能为空")
    private String Dscpt;//交易描述
    @NotNull(message = "交易金额不能为空")
    private BigDecimal Txamt;//交易金额
    @NotBlank(message = "企业号不能为空")
    private String MerId;
    @NotBlank(message = "企业名称不能为空")
    private String MerName;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;
    @NotBlank(message = "交易流水号不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易码不能为空")
    private String TxnId;



}
