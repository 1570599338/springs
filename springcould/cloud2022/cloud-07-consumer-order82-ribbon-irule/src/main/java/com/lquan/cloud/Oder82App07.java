package com.lquan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Oder82App07 {
    public static void main(String[] args) {
        SpringApplication.run(Oder82App07.class,args);
    }
}
