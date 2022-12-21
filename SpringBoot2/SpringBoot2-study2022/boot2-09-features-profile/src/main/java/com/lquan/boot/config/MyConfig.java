package com.lquan.boot.config;

import com.lquan.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author lquan
 * @create 2022- 12-21 上午1:52
 * @description
 */
@Configuration
public class MyConfig {

    @Profile("test")
    @Bean
    public Color red(){
        return  new Color("color_test");
    }

    @Profile("dev")
    @Bean
    public Color colordev(){
        return  new Color("color_dev");
    }

    @Profile("mypro")
    @Bean
    public Color colorPro(){
        return  new Color("color_mypro");
    }
}
