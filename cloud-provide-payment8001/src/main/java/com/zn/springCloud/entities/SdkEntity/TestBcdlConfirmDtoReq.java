package com.zn.springCloud.entities.SdkEntity;



import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class TestBcdlConfirmDtoReq {
  @NotBlank(message = "操作类型不能为空")
  private String opertp;
 //@NotBlank(message = "签约类型不能为空")
  private String confirmtype;
 @NotBlank(message = "企业号不能为空")
  private String cifno;
 @NotBlank(message = "企业名称不能为空")
  private String cifName;
 @NotBlank(message = "主账号不能为空")
  private String priacctno;
 @NotBlank(message = "主账户名称不能为空")
  private String priacctnm;
  private String subacctno;//子账号
  private String subacctnm;//子账户名称
  private String limit;//签约权限
  private BigDecimal limit1;//单笔限额
  private BigDecimal limit2;//当日限额
  private BigDecimal limit3;//当月限额
  private String cretype;//证件类型
  private String creno;//证件号码
  private String phone;//联系方式
  private String telno;//座机
  private String opnbrno;//签约机构
  private String teller;//签约柜员
  private String passwd;//凭证号码
 @NotBlank(message = "交易编码不能为空")
  private String txno;//交易编码

 // private String termacctno;//解约账号

 @NotBlank(message = "交易流水号不能为空")
  private String txnSeq;
 @NotBlank(message = "交易时间不能为空")
  private String txnTime;
  //private String filename;















}
