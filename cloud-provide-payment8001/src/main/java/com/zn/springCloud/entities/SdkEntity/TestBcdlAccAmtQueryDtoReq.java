package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestBcdlAccAmtQueryDtoReq {
   // @NotBlank(message = "账号不能为空")
    private String Actno;//账号
    @NotBlank(message = "企业名称不能为空")
    private String MerName;
    @NotBlank(message = "企业号不能为空")
    private String MerId;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;
    @NotBlank(message = "交易流水号不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易码不能为空")
    private String TxnId;
}
