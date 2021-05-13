package com.zn.springCloud.service.impl;

import com.dhcc.client.api.swaggerTest.BcdlConfirmControllerApiService;
import com.dhcc.client.model.swaggerTest.*;
import com.dhcc.entity.KeyEntity;
import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.SdkEntity.*;
import com.zn.springCloud.service.SdkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@Slf4j
public class SdkServiceImpl implements SdkService {

    @Autowired
    private BcdlConfirmControllerApiService bcdlConfirmControllerApiService;

    @Value("${sign.encryptpubkey}")
    public static String encryptPubKey1;
    @Value("${sign.encryptpubkey}")
    public String encryptPubKey2;

    @Override
    public CommentResule testBcdlConfirmQry(TestBcdlConfirmQryDtoReq testBcdlConfirmQryDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlConfirmQryDtoReReq bcdlConfirmQryDtoReReq = new BcdlConfirmQryDtoReReq();
        BeanUtils.copyProperties(testBcdlConfirmQryDtoReq, bcdlConfirmQryDtoReReq);
        String encryptPubKey = KeyEntity.encryptPubKey;
        System.out.println(encryptPubKey1);
        System.out.println(encryptPubKey2);
        try{
            bcdlConfirmControllerApiService.bcdlConfirmQryUsingPOST(bcdlConfirmQryDtoReReq);
        }catch(Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }

    @Override
    public CommentResule testbcdlBankConfirmQry(TestBcdlBankConfirmQryDtoReq testBcdlBankConfirmQryDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlBankConfirmQryDtoReq bcdlBankConfirmQryDtoReq = new BcdlBankConfirmQryDtoReq();
        BeanUtils.copyProperties(testBcdlBankConfirmQryDtoReq, bcdlBankConfirmQryDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlBankConfirmQryUsingPOST(bcdlBankConfirmQryDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }

    @Override
    public CommentResule testbcdlConfirm(MultipartFile file, TestBcdlConfirmDtoReq testBcdlConfirmDtoReq){
        CommentResule commentResule = new CommentResule();
        try{
            bcdlConfirmControllerApiService.bcdlConfirmUsingGET(testBcdlConfirmDtoReq.getCifName(),testBcdlConfirmDtoReq.getCifno(),testBcdlConfirmDtoReq.getConfirmtype(),
                    testBcdlConfirmDtoReq.getCreno(),testBcdlConfirmDtoReq.getCretype(),testBcdlConfirmDtoReq.getLimit(),testBcdlConfirmDtoReq.getLimit1(),
                    testBcdlConfirmDtoReq.getLimit2(),testBcdlConfirmDtoReq.getLimit3(),testBcdlConfirmDtoReq.getOpertp(),testBcdlConfirmDtoReq.getOpnbrno(),
                    testBcdlConfirmDtoReq.getPasswd(),testBcdlConfirmDtoReq.getPhone(),testBcdlConfirmDtoReq.getPriacctnm(),testBcdlConfirmDtoReq.getPriacctno(),
                    testBcdlConfirmDtoReq.getSubacctnm(),testBcdlConfirmDtoReq.getSubacctno(),testBcdlConfirmDtoReq.getTeller(),testBcdlConfirmDtoReq.getTelno(),
                    testBcdlConfirmDtoReq.getTxnSeq(),testBcdlConfirmDtoReq.getTxnTime(),testBcdlConfirmDtoReq.getTxno(),file);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }
    @Override
    public CommentResule testbcdlConfirmPay(TestBcdlConfirmPayDtoReq testBcdlConfirmPayDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlConfirmPayDtoReq bcdlConfirmPayDtoReq = new BcdlConfirmPayDtoReq();
        BeanUtils.copyProperties(testBcdlConfirmPayDtoReq, bcdlConfirmPayDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlConfirmPayUsingPOST(bcdlConfirmPayDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }
    @Override
    public CommentResule testbcdlBatchTransfer(TestBcdlBatchTransferDtoReq testBcdlBatchTransferDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlBatchTransferDtoReq bcdlBatchTransferDtoReq = new BcdlBatchTransferDtoReq();
        BeanUtils.copyProperties(testBcdlBatchTransferDtoReq, bcdlBatchTransferDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlBatchTransferUsingPOST(bcdlBatchTransferDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }
    @Override
    public CommentResule testbcdlTransfer(TestBcdlTransferDtoReq testBcdlTransferDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlTransferDtoReq bcdlTransferDtoReq = new BcdlTransferDtoReq();
        BeanUtils.copyProperties(testBcdlTransferDtoReq, bcdlTransferDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlTransferUsingPOST(bcdlTransferDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }
    @Override
    public CommentResule testbcdlAccnoQuery(TestBcdlAccnoQueryDtoReq testBcdlAccnoQueryDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlAccnoQueryDtoReq bcdlAccnoQueryDtoReq = new BcdlAccnoQueryDtoReq();
        BeanUtils.copyProperties(testBcdlAccnoQueryDtoReq, bcdlAccnoQueryDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlAccnoQueryUsingPOST(bcdlAccnoQueryDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }

    @Override
    public CommentResule testbcdlAccAmtQuery(TestBcdlAccAmtQueryDtoReq testBcdlAccAmtQueryDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlAccAmtQueryDtoReq bcdlAccAmtQueryDtoReq = new BcdlAccAmtQueryDtoReq();
        BeanUtils.copyProperties(testBcdlAccAmtQueryDtoReq, bcdlAccAmtQueryDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlAccAmtQueryUsingPOST(bcdlAccAmtQueryDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }

    @Override
    public CommentResule testbcdlTradeQuery(TestBcdlTradeQueryDtoReq testBcdlTradeQueryDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlTradeQueryDtoReq bcdlTradeQueryDtoReq = new BcdlTradeQueryDtoReq();
        BeanUtils.copyProperties(testBcdlTradeQueryDtoReq, bcdlTradeQueryDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlTradeQueryUsingPOST(bcdlTradeQueryDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }

    @Override
    public CommentResule testbcdlTradeStsQry(TestBcdlTradeStsQryDtoReq testBcdlTradeStsQryDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlTradeStsQryDtoReq bcdlTradeStsQryDtoReq = new BcdlTradeStsQryDtoReq();
        BeanUtils.copyProperties(testBcdlTradeStsQryDtoReq, bcdlTradeStsQryDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlTradeStsQryUsingPOST(bcdlTradeStsQryDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }

    @Override
    public CommentResule bcdlRoleChange(TestBcdlRoleChangeDtoReq testBcdlRoleChangeDtoReq){
        CommentResule commentResule = new CommentResule();
        BcdlRoleChangeDtoReq bcdlRoleChangeDtoReq = new BcdlRoleChangeDtoReq();
        BeanUtils.copyProperties(testBcdlRoleChangeDtoReq, bcdlRoleChangeDtoReq);
        try{
            bcdlConfirmControllerApiService.bcdlRoleChangeUsingPOST(bcdlRoleChangeDtoReq);
        }catch(Exception e){
            log.info(e.getMessage());
            commentResule = new CommentResule<>(9999, "失败", null);
            return commentResule;
        }
        commentResule = new CommentResule<>(0000, "成功", null);
        return commentResule;
    }
}
