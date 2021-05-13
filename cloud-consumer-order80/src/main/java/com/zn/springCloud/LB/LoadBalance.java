package com.zn.springCloud.LB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
