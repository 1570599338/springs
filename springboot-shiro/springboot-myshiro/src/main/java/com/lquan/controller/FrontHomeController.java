package com.lquan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springs
 * @description: 前端页面
 * @author: lquan
 * @create: 2022-02-18 14:20
 **/
@Controller
@RequestMapping("/front")
public class FrontHomeController {

    private String prefix = "/front/pages/";

    // 系统首页
    @GetMapping("/index")
    public String indexFront( ModelMap mmap) {
        return "front/index";
    }


    // 愿望清单
    @RequestMapping("/wishes")
    public String frontwishes( ModelMap mmap) {

         return prefix + "wishes";
    }


    // 圆梦故事
    @RequestMapping("/realizations")
    public String frontRealizations( ModelMap mmap) {

        return prefix + "realizations";
    }

    // 联系我们
    @RequestMapping("/contact")
    public String frontContact( ModelMap mmap) {

        return prefix + "contact";
    }



    // 详细信息
    @RequestMapping("/wish")
    public String frontWishe( ModelMap mmap) {

        return prefix + "wish";
    }

    // 详细信息
    @RequestMapping("/apply")
    public String frontApply( ModelMap mmap) {

        return prefix + "apply";
    }
}
