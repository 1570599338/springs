package com.lquan.controller;

import com.lquan.bean.School;
import com.lquan.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

/**
 * @program: springs
 * @description: hello测试
 * @author: lquan
 * @create: 2022-02-16 16:24
 **/

@Controller
public class HelloController {


    @RequestMapping("hello")
    public String hello( Model model) {
        model.addAttribute("name","Hello Word!");
        return "hello";
    }



    @RequestMapping("express-var")
    public String express_var( Model model) {
        Student student = new Student();
        student.setId(1);
        student.setAge(19);
        student.setEmail("110@qq.com");
        student.setName("张三");
        model.addAttribute("name","Hello Word!");

        model.addAttribute("myname","Hello Word!");
        model.addAttribute("student",student);
        model.addAttribute("mystudent",student);
        return "express-var";
    }


    @RequestMapping("express-var-ref")
    public String express_var_ref( Model model) {
        Student student = new Student();
        student.setId(1);
        student.setAge(19);
        student.setEmail("110@qq.com");
        student.setName("张三");

        School school = new School();
        school.setId(99);
        student.setName("希望小学");
        school.setEmail("xiwang@qq.com");
        school.setAdress("北京朝阳区");
        school.setStudent(student);


        model.addAttribute("name","Hello Word!");

        model.addAttribute("myname","Hello Word!");
        model.addAttribute("student",student);
        model.addAttribute("mystudent",student);
        model.addAttribute("school",school);



        return "express-var-ref";
    }


}
