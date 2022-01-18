package com.lquan.pay.controller;

import com.lquan.pay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 测试支付宝支付问题
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private AlipayService alipayService;

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

    /**
     * 跳转到支付界面
     * @return
     * @throws Exception
     */
    @GetMapping("/topay")
    @ResponseBody
    public String pay() throws Exception {
        String form = alipayService.toPay(String.valueOf(new Date().getTime()),
                720.0, "易购商城", "订单描述");
        return form;
    }
}
