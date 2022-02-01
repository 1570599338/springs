package com.lquan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    @RequestMapping("/")
    public  String index(Model model){

        model.addAttribute("name","hello world!!!");
        return "login";
    }

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

    @RequestMapping("/login")
    public  String toLogion(String name,String password){


        // 获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 封装登陆用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name,password);
        //执行登陆方法
        subject.login(usernamePasswordToken);


        return "test";
    }


    @RequestMapping("/unAuth")
    public  String unAuth(Model model){


        return "unAuth";
    }




}
