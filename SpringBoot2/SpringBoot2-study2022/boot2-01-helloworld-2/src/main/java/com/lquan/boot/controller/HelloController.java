package com.lquan.boot.controller;

import com.lquan.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lquan
 * @create 2022- 11-27 下午9:12
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("hello")
    public Person hello(){

        return person;
    }
}
