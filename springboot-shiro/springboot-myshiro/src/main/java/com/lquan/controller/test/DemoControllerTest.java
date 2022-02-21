package com.lquan.controller.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
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
@RequestMapping("/demo")
public class DemoControllerTest {
    private String prefix = "/demo/form/";

    @RequestMapping("/jasny")
    public  String index(Model model){


        return prefix+"jasny";
    }



    @RequestMapping("/upload")
    public  String testThymeleaf(Model model){


        return prefix+"upload";
    }




}
