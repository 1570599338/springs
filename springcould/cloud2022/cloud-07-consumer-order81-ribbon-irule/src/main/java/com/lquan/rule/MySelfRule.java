package com.lquan.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lquan
 * @create 2022- 12-26 上午1:34
 * @description
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule(){

        return new RandomRule();
    }
}
