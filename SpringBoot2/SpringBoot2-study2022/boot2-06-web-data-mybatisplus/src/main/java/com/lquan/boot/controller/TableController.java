package com.lquan.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lquan.boot.bean.User;
import com.lquan.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * @author lquan
 * @create 2022- 12-05 上午12:06
 * @description
 */
@Controller
public class TableController {

    /**
     *
     * @param a  不带请求参数或者参数类型不对  400；Bad Request  一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){

       // int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

      //  userService.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @Autowired
    UserService userService;

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){

        List<User> userList = userService.list();

       // model.addAttribute("userList",userList);
        Page<User> userPage = new Page<>(pn,2);

        Page<User> page = userService.page(userPage, null);

        model.addAttribute("users",page);
        //表格内容的遍历
        List<User> usersx = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "123444"),
                new User("haha", "aaaaa"),
                new User("hahas", "aaaaas"),
                new User("hehe ", "aaddd"));
        //model.addAttribute("users",usersx);

        return "table/dynamic_table";
    }


    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
