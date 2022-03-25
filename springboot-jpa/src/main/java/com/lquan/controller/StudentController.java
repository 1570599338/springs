package com.lquan.controller;

import com.lquan.entry.Student;
import com.lquan.entry.User;
import com.lquan.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 19:51
 **/
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private IStudent studentService;

    @GetMapping("/find/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
       Student student = studentService.findStudentByid(id);


        return student==null?"无":student.toString();
    }

}
