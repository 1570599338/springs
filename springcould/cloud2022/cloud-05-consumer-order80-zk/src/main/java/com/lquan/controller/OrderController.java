package com.lquan.controller;

/**
 * @program: springcould
 * @description: 订单
 * @author: lquan
 * @create: 2022-12-23 12:59
 **/

import com.lquan.bean.CommonResult;
import com.lquan.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RestTemplate restTemplate;
    //String urlStr="http://127.0.0.1:8001/";
    String urlStr="http://provider-payment05/";
    
    @GetMapping("/")
    public  void  getStr(){

        String str = restTemplate.getForObject(urlStr+"payment/get/4", String.class);
        log.info("返回值：{}",str);
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id) {
        log.info("queryById->查询参数:{}",id);
        CommonResult<Payment> object = restTemplate.getForObject(urlStr + "payment/get/" + id, CommonResult.class);
        return object;
    }

    /**
     *
     * @param payment
     * @return
     */
    @RequestMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("create->参数:{}",payment);
        CommonResult<Payment> object = restTemplate.postForObject(urlStr + "payment/add",payment,CommonResult.class);
        return object;
    }


}
