package com.lquan.layui.service;

import com.lquan.layui.domain.TbUser;

public interface TokenUserService {

    String findUserId(String token);

    TbUser findTbUser(String token);

}
