package com.lquan.service.impl;

import com.lquan.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author lquan
 * @create 2022- 12-29 上午1:32
 * @description
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return  "-----PaymentFallbackService fall back-paymentInfo_OK , (┬ ＿ ┬)" ;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return  "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬ ＿ ┬)" ;
    }

    @Override
    public String paymentInfo_Exception(Integer id) {
       return  "-----PaymentFallbackService fall back-paymentInfo_Exception , (┬ ＿ ┬)" ;
    }
}
