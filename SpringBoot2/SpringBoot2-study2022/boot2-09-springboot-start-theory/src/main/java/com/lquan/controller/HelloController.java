package com.lquan.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lquan
 * @create 2022- 12-21 下午11:13
 * @description
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(){


        return "hello world !!";
    }
}
