package com.lquan.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("provider-payment08")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/openfegin")
    public String paymentIRule();
}
