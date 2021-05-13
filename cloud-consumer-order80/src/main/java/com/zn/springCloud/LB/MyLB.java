package com.zn.springCloud.LB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright: Copyright (c) 2020 东华软件股份公司
 * @Description: 自写负载均衡轮询算法
 * @author: zhangna
 * @date: 2021/1/13 10:30
 *
 */
@Component
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;

        // do{}whlie();   ----->  自旋锁
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            /*
            this.atomicInteger.compareAndSet(current,next)：CAS
            param:current：期望值，next：更新值
            desc:若当前值与期望值相等，则更新this.atomicInteger为next，且返回true
            *
            * */
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("------------第"+next+"次访问------------");
        return next;
    }


    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
