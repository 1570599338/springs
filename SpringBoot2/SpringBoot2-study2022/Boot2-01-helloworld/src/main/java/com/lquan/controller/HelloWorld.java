package com.lquan.controller;

import com.lquan.bean.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lquan
 * @create 2022- 11-26 下午2:23
 * @description
 */
@RestController
public class HelloWorld {


    @Autowired(required = false)
    Bus bus;

    @RequestMapping("/bus")
    public String bus() {
        return bus.toString();
    }

    @RequestMapping("/hello")
    public String hellow() {
        return "hello world !!";
    }


}
