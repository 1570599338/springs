package com.lquan.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-26 19:36
 **/
@Configuration
public class FeginConfig {

    /**
     * OpenFeign日志打印功能
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){

        return  Logger.Level.FULL;
    }
}
