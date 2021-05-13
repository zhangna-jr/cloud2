package com.zn.springCloud.service;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.SdkEntity.*;
import org.springframework.web.multipart.MultipartFile;

public interface SdkService {

    public CommentResule testBcdlConfirmQry(TestBcdlConfirmQryDtoReq testBcdlConfirmQryDtoReq);

    public CommentResule testbcdlBankConfirmQry(TestBcdlBankConfirmQryDtoReq testBcdlBankConfirmQryDtoReq);

    public CommentResule testbcdlConfirm(MultipartFile file, TestBcdlConfirmDtoReq testBcdlConfirmDtoReq);

    public CommentResule testbcdlConfirmPay(TestBcdlConfirmPayDtoReq testBcdlConfirmPayDtoReq);

    public CommentResule testbcdlBatchTransfer(TestBcdlBatchTransferDtoReq testBcdlBatchTransferDtoReq);

    public CommentResule testbcdlTransfer(TestBcdlTransferDtoReq testBcdlTransferDtoReq);

    public CommentResule testbcdlAccnoQuery(TestBcdlAccnoQueryDtoReq testBcdlAccnoQueryDtoReq);

    public CommentResule testbcdlAccAmtQuery(TestBcdlAccAmtQueryDtoReq testBcdlAccAmtQueryDtoReq);

    public CommentResule testbcdlTradeQuery(TestBcdlTradeQueryDtoReq testBcdlTradeQueryDtoReq);

    public CommentResule testbcdlTradeStsQry(TestBcdlTradeStsQryDtoReq testBcdlTradeStsQryDtoReq);

    public CommentResule bcdlRoleChange(TestBcdlRoleChangeDtoReq testBcdlRoleChangeDtoReq);
}
