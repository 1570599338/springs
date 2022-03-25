package com.lquan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 19:27
 **/

@Controller
public class IndexController {


    @GetMapping("test")
    public String  index( Model model){
        model.addAttribute("name","Hello trest!");
        return  "test";
    }


    @RequestMapping("hello")
    public String hello( Model model) {
        model.addAttribute("name","Hello Word!");
        return "hello";
    }
}
