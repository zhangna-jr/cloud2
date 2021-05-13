package com.zn.springCloud.entities.SdkEntity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class TestBcdlRoleChangeDtoReq {
    @NotBlank(message = "交易码不能为空")
    private String TxnId;
    @NotBlank(message = "交易流水号不能为空")
    private String TxnSeq;
    @NotBlank(message = "交易时间不能为空")
    private String TxnTime;
    @NotBlank(message = "企业号不能为空")
    private String MerId;
    private String MerName;//企业名称
    @NotBlank(message = "签约账号不能为空")
    private String Actno;//签约账号
    private String QryChange;//查询（余额、明细）权限
    private String QyhzChange;//签约互转
    private String ZzhkChange;//转帐汇款
    private String LzhdChange;//来账回单
    private String DxtxChange;//短信提醒
    private String DzdChange;//对账单推送
    private String chrgChange;//手续费优惠
    private BigDecimal limit1;//单笔限额
    private BigDecimal limit2;//当日限额
    private BigDecimal limit3;//当月限额

}
