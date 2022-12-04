package com.lquan.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lquan
 * @create 2022- 11-30 下午7:15
 * @description
 * 主要处理转发过程中的参数问题
 * 方法1、利用@RequestAttribute
 * 方法2、利用request.getAttribute("xxxx")；
 *
 */

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goTopage(HttpServletRequest request){
        request.setAttribute("msg","成功...！");
        request.setAttribute("code",200);
        return "forward:/success";
    }



    @ResponseBody
    @GetMapping("/success")
    public Map success(HttpServletRequest request,
                       @RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code){
        Map<String,Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");

        map.put("msg",msg);
        map.put("code",code);
        map.put("msg1",msg1);
        return map;
    }









    // 复杂参数
    @GetMapping("/param")
    public String testParam(Map<String,String> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello","world66");
        model.addAttribute("world","hello66！");
        request.setAttribute("msgs","helloworld");

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);

        return "forward:/testParam";

    }

    @ResponseBody
    @GetMapping("/testParam")
    public Map successParam(HttpServletRequest request,
                       @RequestAttribute("hello") String msg1,
                       @RequestAttribute("world") String msg2,
                       @RequestAttribute("msgs") String msg3){
        Map<String,Object> map = new HashMap<>();
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("msgs");


        map.put("msg1",msg1);
        map.put("msg2",msg2);
        map.put("msg3",msg3);
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }

}
