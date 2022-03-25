package com.lquan.service.impl;

import com.lquan.dao.UserRep;
import com.lquan.entry.User;
import com.lquan.service.IUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 19:01
 **/
@Service
public class UserImpl implements IUser {

    @Resource
    private UserRep userRep;


    @Override
    public User findUserByid(Integer id) {

        return userRep.findOne(id);
    }
}
