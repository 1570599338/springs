package com.lquan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String indexFront(Model model) {
        model.addAttribute("index", Boolean.TRUE);
        return "front/index";
    }


    // 愿望清单
    @RequestMapping("/wishes")
    public String frontwishes( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);

         return prefix + "wishes";
    }


    // 圆梦故事
    @RequestMapping("/realizations")
    public String frontRealizations( Model model) {
        model.addAttribute("realizations",  Boolean.TRUE);

        return prefix + "realizations";
    }


    // 圆梦故事
    @RequestMapping("/realizationInfo")
    public String frontRealizationInfo( Model model) {
        model.addAttribute("realizations",  Boolean.TRUE);

        return prefix + "realization-info";
    }

    // 联系我们
    @RequestMapping("/contact")
    public String frontContact( Model model) {
        model.addAttribute("contact",  Boolean.TRUE);
        return prefix + "contact";
    }



    // 详细信息
    @RequestMapping("/wish")
    public String frontWishe( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "wish";
    }

    // 详细信息
    @RequestMapping("/apply")
    public String frontApply( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "apply";
    }

    // 成功
    @RequestMapping("/apply_success")
    public String frontApplySuccess( Model model) {
        model.addAttribute("wishes",  Boolean.TRUE);
        return prefix + "apply_success";
    }
}
