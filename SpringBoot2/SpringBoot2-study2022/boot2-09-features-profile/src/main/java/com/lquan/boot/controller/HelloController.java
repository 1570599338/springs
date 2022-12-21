package com.lquan.boot.controller;

import com.lquan.boot.bean.Color;
import com.lquan.boot.bean.Persion;
import com.lquan.boot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lquan
 * @create 2022- 12-21 上午12:36
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    Student student;

    @Autowired
    Persion persion;

    @Value("${userx.name:李四}")
    private String userNamex;

    @RequestMapping("hello")
    public String getIndex(){

        return  "hello "+userNamex+"!" ;
    }

    @RequestMapping("/")
    public Student getPersion(){

        return  this.student;
    }


    @RequestMapping("/c")
    public String getClazz(){

        return  "hello "+userNamex+"!"+persion.getClass().toGenericString() ;
    }

    @Autowired
    public Color color;

    @RequestMapping("/m")
    public String getMethod(){

        return  "hello "+userNamex+"!"+color.getName() ;
    }
}
