package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestBcdlConfirmQryDtoReq {

    @NotBlank(message = "客户号不能为空")
    private String MerId;
    //@NotBlank(message = "账号不能为空")
    private String Actno;


    @NotBlank(message = "交易码不能为空")
    private String TxnId;
    @NotBlank(message = "交易流水不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;
    @NotBlank(message = "企业名称不能为空")
    private String MerName;

}
