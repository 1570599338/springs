package com.lquan.boot.controller;

import com.lquan.boot.bean.User;
import com.lquan.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author lquan
 * @create 2022- 12-04 下午9:14
 * @description
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired(required = false)
    StringRedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "/login";
    }


    /**
     * 来登录页
     * @return
     */
    @PostMapping(value = "/login")
    public String main(User user, HttpSession session, Model model){
        if(user!=null && StringUtils.hasLength(user.getPassword())&& StringUtils.hasLength(user.getUserName())){
            session.setAttribute("loginUser",user);

            log.info("username={}",user.toString());
            // 登录成功后重定向到main.html，防止重复提交,
            return "redirect:main.html";
        }else{
            model.addAttribute("msgs","登录失败！");
            // 登录失败后将跳转到登录几面并提示错误信息
            return "login";
        }

    }

    @GetMapping("main.html")
    public String mainPage(Model model){

        String main = redisTemplate.opsForValue().get("/main.html");
        String sql = redisTemplate.opsForValue().get("/sql");
        model.addAttribute("mainCount",main);
        model.addAttribute("sqlCount",sql);


        return "main";
    }

    @ResponseBody
    @GetMapping("/sql")
    public  String sql(){

        int count = userService.count();
        log.info("数量:{}", count);

        return "数量："+count;
    }



}
