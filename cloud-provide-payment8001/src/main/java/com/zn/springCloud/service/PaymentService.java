package com.zn.springCloud.service;


import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;

public interface PaymentService {
    CommentResule create(Payment payment) throws Exception;

    CommentResule searceData(Payment payment);
}
