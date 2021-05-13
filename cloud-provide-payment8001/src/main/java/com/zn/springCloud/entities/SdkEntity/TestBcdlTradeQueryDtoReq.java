package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestBcdlTradeQueryDtoReq {
    //@NotBlank(message = "账号不能为空")
    private String Actno;  //账号
    @NotBlank(message = "起始交易日期不能为空" )
    //@DateTimeFormat(pattern = "yyyyMMdd")
    private String StDate;  //起始交易日期
    @NotBlank(message = "截至交易日期不能为空")
    //@DateTimeFormat(pattern = "yyyyMMdd")
    private String EdDate;  //截至交易日期
    private String QryFlag;  //查询标志


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



    /* @NotNull(message = "每页记录数不能为空")
    private Integer pgRcrdNum; //每页记录数
    @NotNull(message = "查询页数索引不能为空")
    private Integer qryPgNumIdnx; //查询页数索引*/
}
