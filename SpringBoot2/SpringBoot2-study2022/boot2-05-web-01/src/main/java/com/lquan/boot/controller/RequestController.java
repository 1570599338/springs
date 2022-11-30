package com.lquan.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

}
