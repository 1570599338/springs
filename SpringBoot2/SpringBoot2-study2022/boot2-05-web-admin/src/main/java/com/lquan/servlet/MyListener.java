package com.lquan.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author lquan
 * @create 2022- 12-06 下午10:44
 * @description
 */
@Slf4j
//@WebListener
public class MyListener implements ServletContextListener {
    /**
     *
     * @param sce Information about the ServletContext that was initialized
     *
     *            监听项目的servlet的初始化
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("监听项目的servlet的初始化");

    }

    /**
     * @param sce Information about the ServletContext that was destroyed
     *                  监听项目的servlet的销毁
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听项目的servlet的销毁");

    }
}
