package com.lquan.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lquan
 * @create 2022- 12-06 下午10:42
 * @description  spring和servlet拦截器/过滤器的写法不同
 *                  spring："/css/**"
 *                  servlet: "/css/*"
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            log.info("初始化init");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter工作！");
        chain.doFilter(request,response);
    }


    @Override
    public void destroy() {
        log.info("销毁");
    }
}
