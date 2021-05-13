package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TestBcdlTransferDtoReq {
    @NotBlank(message = "交易码不能为空")
    private String TxnId;
    @NotBlank(message = "交易流水号不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;//交易时间
    @NotBlank(message = "客户号不能为空")
    private String MerId;//客户号
    @NotBlank(message = "企业名称不能为空")
    private String MerName;//企业名称
    @NotBlank(message = "业务类型不能为空")
    private String Txprtry;//业务类型
    @NotBlank(message = "转账标志不能为空")
    private String ZhFlag;//转账标志,0-普通  1-加急  2-指定日期
    private String Rzdate;//指定入账日期,转账标志为指定日期时填写，其他无效

    @NotBlank(message = "借方账号不能为空")
    private String Actno; //借方账号
    @NotBlank(message = "贷方账号不能为空")
    private String Coractno; //贷方账号
    @NotBlank(message = "贷方账号户名不能为空")
    private String CoractName; //贷方账号户名
    @NotNull(message = "交易金额不能为空")
    private BigDecimal Txamt;//交易金额
    private String BrhNo;//贷方开户行行号
    private String BrhNm;//贷方开户行名称

    //@NotBlank(message = "交易描述不能为空")
    private String Dscpt;//交易描述


    /*@NotBlank(message = "转账类型不能为空")
    private String BxType;//转账类型*/








}
