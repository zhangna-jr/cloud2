package com.zn.springCloud.service;

import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;

public interface HystrixPaymentService {


    public CommentResule paymentInfo_OK();
    public CommentResule paymentInfo_timeout();
    public CommentResule paymentInfo_circultBreaker(Payment payment) throws Exception;
}
