package com.lquan.boot.controller;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lquan
 * @create 2022- 11-28 下午4:24
 * @description
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("****************");

        return "indexx";
    }
}
