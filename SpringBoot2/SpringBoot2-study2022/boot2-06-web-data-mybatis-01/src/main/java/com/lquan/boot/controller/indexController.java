package com.lquan.boot.controller;

import com.lquan.boot.bean.Account;
import com.lquan.boot.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-14 19:25
 **/
@Slf4j
@Controller
public class indexController {


    @Autowired
    AccountService accountService;

    @ResponseBody
    @GetMapping("/acc")
    public Account page(@RequestParam("id") Long id){

        return accountService.getAcc(id);
    }
}
