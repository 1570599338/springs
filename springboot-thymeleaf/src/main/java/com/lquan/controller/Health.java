package com.lquan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-02-16 16:17
 **/

@RestController
public class Health {
    
    @RequestMapping("/health")
    public String health(){
        
        
        return "hell world";
    }
    
}
