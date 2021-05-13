package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class TestBcdlBatchTransferDetailDtoReq {
    @NotBlank(message = "明细号码不能为空")
    private String txmxno;
    @NotBlank(message = "借方账号不能为空")
    private String Actno;
    @NotBlank(message = "贷方账号不能为空")
    private String Coractno;
    @NotBlank(message = "贷方账号户名不能为空")
    private String CoractName;
    @NotBlank(message = "交易金额不能为空")
    private BigDecimal Txamt;
    private String BrhNo;//贷方开户行行号
    private String BrhNm;//贷方开户行名称
    private String Dscpt;//交易描述
    private String ActTel;//借方联系方式
    private String CoractTel;//贷方联系方式
    private String traceNoDetail;//明细流水号
}
