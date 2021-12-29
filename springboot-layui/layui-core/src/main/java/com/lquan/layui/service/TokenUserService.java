package com.lquan.layui.service;

import com.lquan.layui.domain.TbUser;

/**
 * ClassName:    TokenService
 * Package:    com.kaishun.study.service
 * Description:
 * Datetime:    2020/2/26   10:55
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public interface TokenUserService {

    String findUserId(String token);

    TbUser findTbUser(String token);

}
