package com.lquan.boot.controller;

import com.lquan.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lquan
 * @create 2022- 12-21 下午11:13
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(){

        String hello = helloService.sayHello("China");
        return hello;
    }
}
