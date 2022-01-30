package com.lquan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springs
 * @description: index的controller
 * @author: lquan
 * @create: 2022-01-30 15:47
 **/
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/test")
    @ResponseBody
    public  String  test(){

        return "hello world";
    }

    @RequestMapping("/test2")
    public  String testThymeleaf(Model model){

        model.addAttribute("name","hello world!!!");
        return "test";
    }

}
