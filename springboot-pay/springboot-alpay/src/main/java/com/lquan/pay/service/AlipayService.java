package com.lquan.pay.service;

import org.springframework.stereotype.Service;


public interface AlipayService {

    public String toPay(String orderId, double price, String orderName, String orderDesc) throws Exception;


}
