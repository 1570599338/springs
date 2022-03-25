package com.lquan.service;

import com.lquan.entry.User;

/**
 * @program: springs
 * @description: 接口
 * @author: lquan
 * @create: 2022-03-25 19:00
 **/
public interface IUser {

    User findUserByid(Integer id);
}
