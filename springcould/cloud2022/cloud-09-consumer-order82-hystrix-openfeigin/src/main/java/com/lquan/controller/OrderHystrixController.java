package com.lquan.controller;

import com.lquan.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-27 19:45
 * 配置全局的服务降级
 *              优点：不用每个方法都配置，代码不会显得臃肿
 *              缺点：和业务混在一起显得混乱，具体是哪个接口出问题，不太好追踪
 **/
@Slf4j
@RequestMapping("/consumer/payment")
@RestController
public class OrderHystrixController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){

        return paymentService.paymentInfo_OK(id);
    }


    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){

        return  paymentService.paymentInfo_TimeOut(id);
    }

    @GetMapping("/hystrix/exception/{id}")
    public String paymentInfo_Exception(@PathVariable("id") Integer id){

        return  paymentService.paymentInfo_Exception(id);
    }


}
