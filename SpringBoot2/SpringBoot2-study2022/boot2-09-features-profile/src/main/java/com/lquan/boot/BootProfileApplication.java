package com.lquan.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class BootProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootProfileApplication.class, args);

        //
        ConfigurableEnvironment environment = run.getEnvironment();

        // 系统的环境
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();

        //系统的配置
        Map<String, Object> systemProperties = environment.getSystemProperties();

        System.out.println(systemEnvironment);
        System.out.println(systemProperties);
    }

}
