package com.zn.springCloud.controller;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.SdkEntity.*;
import com.zn.springCloud.service.SdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "testSdk")
public class TestSdkProjectController {

    @Autowired
    private SdkService sdkService;


    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: SDK测试签约查询
     * @author: zhangna
     * @date: 2020/12/3 10:06
     *
     */
    @RequestMapping(value = "testBcdlConfirmQry")
    public CommentResule testBcdlConfirmQry(@RequestBody @Valid TestBcdlConfirmQryDtoReq testBcdlConfirmQryDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testBcdlConfirmQry(testBcdlConfirmQryDtoReq);
        return commentResule;
    }
    
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 签约企业信息查询
     * @author: zhangna
     * @date: 2020/12/3 10:47
     *
     */
    /*@RequestMapping(value = "testbcdlBankConfirmQry")
    public CommentResule testbcdlBankConfirmQry (@RequestBody @Valid TestBcdlBankConfirmQryDtoReq testBcdlBankConfirmQryDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlBankConfirmQry(testBcdlBankConfirmQryDtoReq);
        return commentResule;
    }*/
    
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 签约信息管理
     * @author: zhangna
     * @date: 2020/12/3 10:59
     *
     */
    /*@GetMapping(value = "testbcdlConfirm")
    public CommentResule testbcdlConfirm(@RequestParam(value = "filename", required = false) MultipartFile file, @Valid TestBcdlConfirmDtoReq testBcdlConfirmDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlConfirm(file,testBcdlConfirmDtoReq);
        return commentResule;
    }*/
    
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 签约账户互转
     * @author: zhangna
     * @date: 2020/12/3 11:13
     *
     */
    @RequestMapping(value = "testbcdlConfirmPay")
    public CommentResule testbcdlConfirmPay(@Valid @RequestBody TestBcdlConfirmPayDtoReq testBcdlConfirmPayDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlConfirmPay(testBcdlConfirmPayDtoReq);
        return commentResule;
    }
    
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 转账汇款批量处理
     * @author: zhangna
     * @date: 2020/12/3 11:31
     *
     */
    @RequestMapping(value = "testbcdlBatchTransfer")
    public CommentResule testbcdlBatchTransfer(@Valid @RequestBody TestBcdlBatchTransferDtoReq testBcdlBatchTransferDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlBatchTransfer(testBcdlBatchTransferDtoReq);
        return commentResule;
    }
    
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 转账汇款
     * @author: zhangna
     * @date: 2020/12/3 11:37
     *
     */
    @RequestMapping(value = "testbcdlTransfer")
    public CommentResule testbcdlTransfer(@Valid @RequestBody TestBcdlTransferDtoReq testBcdlTransferDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlTransfer(testBcdlTransferDtoReq);
        return commentResule;
    }
    
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 账户信息查询申请
     * @author: zhangna
     * @date: 2020/12/3 11:41
     *
     */
    @RequestMapping(value = "testbcdlAccnoQuery")
    public CommentResule testbcdlAccnoQuery(@Valid @RequestBody TestBcdlAccnoQueryDtoReq testBcdlAccnoQueryDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlAccnoQuery(testBcdlAccnoQueryDtoReq);
        return commentResule;
    }
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 账户余额查询
     * @author: zhangna
     * @date: 2020/12/3 14:01
     *
     */
    @RequestMapping(value = "testbcdlAccAmtQuery")
    public CommentResule testbcdlAccAmtQuery(@Valid @RequestBody TestBcdlAccAmtQueryDtoReq testBcdlAccAmtQueryDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlAccAmtQuery(testBcdlAccAmtQueryDtoReq);
        return commentResule;
    }
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 交易明细查询
     * @author: zhangna
     * @date: 2020/12/3 14:07
     *
     */
    @RequestMapping(value = "testbcdlTradeQuery")
    public CommentResule testbcdlTradeQuery(@Valid @RequestBody TestBcdlTradeQueryDtoReq testBcdlTradeQueryDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlTradeQuery(testBcdlTradeQueryDtoReq);
        return commentResule;
    }
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 交易状态查询
     * @author: zhangna
     * @date: 2020/12/3 14:11
     *
     */
    @RequestMapping(value = "testbcdlTradeStsQry")
    public CommentResule testbcdlTradeStsQry(@Valid @RequestBody TestBcdlTradeStsQryDtoReq testBcdlTradeStsQryDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.testbcdlTradeStsQry(testBcdlTradeStsQryDtoReq);
        return commentResule;
    }
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 功能权限变更
     * @author: zhangna
     * @date: 2020/12/3 14:17
     *
     */
    /*@RequestMapping(value = "bcdlRoleChange")
    public CommentResule bcdlRoleChange(@Valid @RequestBody TestBcdlRoleChangeDtoReq testBcdlRoleChangeDtoReq){
        CommentResule commentResule = new CommentResule();
        commentResule = sdkService.bcdlRoleChange(testBcdlRoleChangeDtoReq);
        return commentResule;
    }*/


}
