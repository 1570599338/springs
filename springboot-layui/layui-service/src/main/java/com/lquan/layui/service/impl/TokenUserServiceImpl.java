package com.lquan.layui.service.impl;

import com.lquan.layui.domain.TbUser;
import com.lquan.layui.service.TbUserService;
import com.lquan.layui.service.TokenUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * ClassName:    TokenUserServiceImpl
 * Description:
 */
@Service
public class TokenUserServiceImpl implements TokenUserService {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TbUserService tbUserService;

    @Override
    public String findUserId(String token) {
     //   return redisService.get(token);
        return token == null ? null : (String)this.redisTemplate.opsForValue().get(token);
    }

    @Override
    public TbUser findTbUser(String token) {
        String userId = this.findUserId(token);
        return tbUserService.queryById(userId);
    }
}
