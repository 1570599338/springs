package com.lquan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-27 19:07
 **/
@Service
public class PaymentService {

    //成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 5;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }

    public String paymentInfo_TimeOutFallBack(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  服务降级paymentInfo_TimeOutFallBack,id：  "+id+"\t"+"啊啊啊"+" 耗时(秒)";
    }


    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Exception(Integer id){
        int a = 10/0;
       return " paymentInfo_Exception,id：  "+id;
    }

}
