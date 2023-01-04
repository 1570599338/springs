package com.lquan.controller;

import com.lquan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-27 19:10
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }

}
