package com.lquan.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lquan
 * @create 2022- 12-22 上午1:07
 * @description
 */
public class MyApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener……  onApplicationEvent 。。。。。。。");
    }
}
