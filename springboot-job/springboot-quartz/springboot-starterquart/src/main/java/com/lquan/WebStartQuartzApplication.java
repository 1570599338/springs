package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: springs
 * @description: 启动
 * @author: lquan
 * @create: 2022-01-20 16:06
 **/

@SpringBootApplication
public class WebStartQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStartQuartzApplication.class,args);
    }
}
