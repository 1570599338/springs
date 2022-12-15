package com.lquan.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lquan.boot.bean.User;
import com.lquan.boot.mapper.UserMapper;
import com.lquan.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 21:56
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
}
