package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcould
 * @description: order
 * @author: lquan
 * @create: 2022-12-23 11:55
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class Oder82App08 {
    public static void main(String[] args) {
        SpringApplication.run(Oder82App08.class,args);
    }
}
