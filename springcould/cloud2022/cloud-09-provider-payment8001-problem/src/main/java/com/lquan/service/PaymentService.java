package com.lquan.service;

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

    /**
     * 延时
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }


    /**
     * 异常
     * @param id
     * @return
     */
    public String paymentInfo_Exception(Integer id){
      int a = 10/0;
        return "paymentInfo_Exception 异常";
    }

}
