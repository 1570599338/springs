package com.lquan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springs
 * @description: 健康检查
 * @author: lquan
 * @create: 2022-03-07 21:31
 **/
@Controller
public class Health {
    
    @GetMapping(value="/")
    @ResponseBody
    public String info() {


        return "hello!";
    }

    
}
