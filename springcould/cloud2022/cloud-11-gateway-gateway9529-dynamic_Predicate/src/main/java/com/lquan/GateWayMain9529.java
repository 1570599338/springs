package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-05 18:50
 *      动态路由及断言问题
 **/
@EnableEurekaClient
@SpringBootApplication
public class GateWayMain9529 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9529.class,args);
    }
}
