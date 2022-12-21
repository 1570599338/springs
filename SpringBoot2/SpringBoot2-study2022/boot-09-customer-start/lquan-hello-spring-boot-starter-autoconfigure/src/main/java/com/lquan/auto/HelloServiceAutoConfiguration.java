package com.lquan.auto;

import com.lquan.config.HelloProperties;
import com.lquan.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lquan
 * @create 2022- 12-21 下午6:49
 * @description
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)   //默认HelloProperties放入容器中
public class HelloServiceAutoConfiguration {


    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService(){


        return new HelloService();

    }
}
