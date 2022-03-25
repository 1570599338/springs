package com.lquan.controller;

import com.lquan.entry.User;
import com.lquan.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 17:01
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private  IUser userService;


    @RequestMapping("/w")
    @ResponseBody
    public String  index(){

        return  "hello world!";
    }



    /**
     * 修改愿望申领单
     */
    @GetMapping("/find/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
       User user = userService.findUserByid(id);


       return user==null?"w无":user.toString();
    }


    /**
     * 修改愿望申领单
     */
    @GetMapping("page")
    public String page() {



      return  "/page";
    }





}
