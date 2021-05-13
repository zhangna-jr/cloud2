package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestBcdlBankConfirmQryDtoReq {
    @NotBlank(message = "交易码不能为空")
    private String TxnId;
    @NotBlank(message = "交易流水号不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;
    private String MerId;
    private String MerName;
    private String Actno;
    private String StartDate;
    private String EndDate;
}
