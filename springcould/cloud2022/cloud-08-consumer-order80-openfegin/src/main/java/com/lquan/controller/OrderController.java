package com.lquan.controller;

/**
 * @program: springcould
 * @description: 订单
 * @author: lquan
 * @create: 2022-12-23 12:59
 **/

import com.lquan.bean.CommonResult;
import com.lquan.bean.Payment;
import com.lquan.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;



    @GetMapping("/openfegin")
    public  String  getStrs(){
        String s = paymentFeignService.paymentIRule();
        log.info("返回值：{}",s);
        return  s;
    }
    



}
