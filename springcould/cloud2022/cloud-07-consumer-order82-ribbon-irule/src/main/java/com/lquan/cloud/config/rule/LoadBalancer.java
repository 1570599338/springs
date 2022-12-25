package com.lquan.cloud.config.rule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lquan
 * @create 2022- 12-26 上午2:25
 * @description
 */
public interface LoadBalancer {

   public ServiceInstance serviceInstance( List<ServiceInstance> instances);

}
