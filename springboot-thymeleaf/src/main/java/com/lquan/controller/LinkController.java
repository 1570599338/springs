package com.lquan.controller;

import com.lquan.bean.School;
import com.lquan.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springs
 * @description: hello测试
 * @author: lquan
 * @create: 2022-02-16 16:24
 **/

@Controller
public class LinkController {






    @RequestMapping("link")
    public String express_var( Model model) {

        model.addAttribute("linkUrl","linkUrlxxxx!");
        return "link";
    }




}
