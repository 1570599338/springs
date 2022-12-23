package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description: order
 * @author: lquan
 * @create: 2022-12-23 11:55
 **/
@EnableEurekaClient
@SpringBootApplication
public class Oder80App04 {
    public static void main(String[] args) {
        SpringApplication.run(Oder80App04.class,args);
    }
}
