package com.lquan.cloud;

import com.lquan.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: springcould
 * @description: order
 * @author: lquan
 * @create: 2022-12-23 11:55
 **/
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name="provider-payment07-irule",configuration= MySelfRule.class )
public class Oder81App07 {
    public static void main(String[] args) {
        SpringApplication.run(Oder81App07.class,args);
    }
}
