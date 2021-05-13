package com.zn.springCloud.service.Impl;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zn.springCloud.entities.CommentResule;
import com.zn.springCloud.entities.Payment;
import com.zn.springCloud.service.HystrixPaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentServiceImpl implements HystrixPaymentService {

    @Override
    public CommentResule paymentInfo_OK() {
        return new CommentResule(0000,"线程池："+Thread.currentThread().getName()+"paymentInfo_OK",null);
    }



    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 服务降级
     * @author: zhangna
     * @date: 2021/1/15 16:40
     *
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public CommentResule paymentInfo_timeout() {
        int seconds = 3;
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CommentResule(0000,"线程池："+Thread.currentThread().getName()+"paymentInfo_timeout,耗时："+seconds+"秒",null);
    }
    public CommentResule paymentInfo_timeoutHandler(){
        return new CommentResule(0000,"paymentHystrix系统异常，请10秒钟之后再试",null);
    }
    /**
     * Copyright: Copyright (c) 2020 东华软件股份公司
     * @Description: 服务熔断
     *   当打开断路器后，在10s（时间窗口期）内失败次数占到请求次数的60%后跳闸
     * @author: zhangna
     * @date: 2021/1/15 16:40
     *
     */
    //HystrixCommandProperties
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_circultBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public CommentResule paymentInfo_circultBreaker(Payment payment) throws Exception {
        if(payment.getId()<0){
            throw new Exception("id不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return new CommentResule(0000,Thread.currentThread().getName()+"\t调用成功，流水号为："+serialNumber,null);
    }

    public CommentResule paymentInfo_circultBreakerHandler(Payment payment) {
        return new CommentResule(0000,"id不能为负数,请稍后再试  id:"+payment.getId(),null);
    }




}
