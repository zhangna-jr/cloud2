package com.zn.springCloud.service.impl;

//import com.dhcc.client.api.shbzjjBankpro.BcdlConfirmControllerApiService;
//import com.dhcc.client.model.shbzjjBankpro.BcdlAccAmtQueryDtoReq;
import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import com.zn.springCloud.mapper.PaymentDaoMapper;
import com.zn.springCloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class PaymentImpl implements PaymentService {

    /*@Autowired
    private BcdlConfirmControllerApiService bcdlConfirmControllerApiService;*/

    @Autowired
    private PaymentDaoMapper paymentDaoMapper;

    @Value("${server.port}")
    private String serverPort;
    @Override
    public CommentResule<Payment> create(Payment payment) throws Exception {
        CommentResule paymentCommentResule ;
        int count = 0;
        try{
             count = paymentDaoMapper.create(payment);
        }catch(Exception e){
            e.printStackTrace();
            paymentCommentResule = new CommentResule<>(0000, "失败", null);
            return paymentCommentResule;
        }
        if(count>0) {
            paymentCommentResule = new CommentResule<>(200, "成功,serverPort:"+serverPort, count);
            return paymentCommentResule;
        }
        paymentCommentResule = new CommentResule<>(0000, "失败", null);
        return paymentCommentResule;
    }
    @Override
    public CommentResule searceData(Payment payment){
        CommentResule paymentCommentResule ;
        Payment paymentOne = new Payment();
        int a = 10/2;
        System.out.println(a);
        try{
            paymentOne =  paymentDaoMapper.selectById(payment.getId());
        }catch(Exception e){
            e.printStackTrace();
            paymentCommentResule = new CommentResule(200,"查询失败",null);
        }
        paymentCommentResule = new CommentResule(0000,"查询成功,serverPort:"+serverPort,paymentOne);
        return paymentCommentResule;
    }

}
