package com.lquan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-08 18:07
 *          动态获取配置信息
 **/
@Configuration
public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){

        return  new RestTemplate();
    }
}
