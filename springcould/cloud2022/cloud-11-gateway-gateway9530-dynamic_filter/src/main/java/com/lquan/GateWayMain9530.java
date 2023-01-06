package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description: 自定义全局过滤器
 * @author: lquan
 * @create: 2023-01-06 19:08
 **/

@EnableEurekaClient
@SpringBootApplication
public class GateWayMain9530 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9530.class,args);
    }
}
