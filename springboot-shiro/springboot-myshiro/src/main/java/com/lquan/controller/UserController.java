package com.lquan.controller;

import com.lquan.domain.User;
import com.lquan.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2022-02-09 00:40:35
 */
@Controller
@RequestMapping("/system/user")
public class UserController {
    private String prefix = "system/user";
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }



}

