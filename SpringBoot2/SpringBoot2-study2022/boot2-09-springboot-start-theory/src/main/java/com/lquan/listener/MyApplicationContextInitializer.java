package com.lquan.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lquan
 * @create 2022- 12-22 上午1:06
 * @description
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        System.out.println("ApplicationContextInitializer……  initializer。。。。。。。");

    }
}
