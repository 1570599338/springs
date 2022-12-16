package com.lquan.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springs
 * @description: 统计url的拦截器
 * @author: lquan
 * @create: 2022-12-16 15:49
 **/
@Slf4j
@Component
public class RedisUrlInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate redisTemplate;

    // 前置拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String uri = request.getRequestURI();//获取请求的url
            redisTemplate.opsForValue().increment(uri);//在redis中进行统计
        } catch (Exception e) {
            // 统计异常不做处理
            e.printStackTrace();
        }
        return true;
    }
}
