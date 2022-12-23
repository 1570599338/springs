package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-22 19:14
 **/
@EnableEurekaClient
@SpringBootApplication
public class PayMent8001App04 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8001App04.class,args);
    }
}
