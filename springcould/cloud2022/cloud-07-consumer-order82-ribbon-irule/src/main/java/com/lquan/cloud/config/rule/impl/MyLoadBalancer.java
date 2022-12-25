package com.lquan.cloud.config.rule.impl;

import com.lquan.cloud.config.rule.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lquan
 * @create 2022- 12-26 上午2:27
 * @description
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger ( 0 );

    private  final  int getAndInCrement(){
        int current;
        int next;
        for(;;){
            current=this.atomicInteger.get();
            next=current>=Integer.MAX_VALUE? 0:current+1;
            if (this.atomicInteger.compareAndSet(current,next)){
                return next;
            }
        }
    }


    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> instances) {
        int index = getAndInCrement()%instances.size();
        return instances.get(index);
    }
}
