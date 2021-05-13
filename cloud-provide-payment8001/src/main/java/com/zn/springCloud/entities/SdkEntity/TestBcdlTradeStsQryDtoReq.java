package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestBcdlTradeStsQryDtoReq {

    @NotBlank(message = "账号不能为空")
    private String Txdate; //交易日期
    @NotBlank(message = "企业流水不能为空")
    private String cifTxnSeq; //企业流水
    @NotBlank(message = "转账类型不能为空")
    private String TransferType; //转账类型
    @NotBlank(message = "交易码不能为空")
    private String TxnId;
    @NotBlank(message = "交易流水号不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;
    @NotBlank(message = "企业号不能为空")
    private String MerId;
    @NotBlank(message = "企业名称不能为空")
    private String MerName;


}
