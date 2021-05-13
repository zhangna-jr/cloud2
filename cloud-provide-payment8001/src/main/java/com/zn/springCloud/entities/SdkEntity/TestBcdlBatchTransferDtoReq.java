package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class TestBcdlBatchTransferDtoReq {
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
    @NotBlank(message = "业务类型不能为空")
    private String Txprtry;
    @NotBlank(message = "转账标志不能为空")
    private String ZhFlag;
    private String RzDate;
    private String MsgType;
    @NotBlank(message = "明细笔数不能为空")
    private String Txno;
    private List<TestBcdlBatchTransferDetailDtoReq> TxDataList;
}
