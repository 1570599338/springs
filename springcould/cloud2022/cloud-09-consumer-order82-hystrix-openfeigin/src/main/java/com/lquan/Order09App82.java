package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-27 21:31
 **/
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Order09App82 {

    public static void main(String[] args) {

        SpringApplication.run(Order09App82.class,args);

    }
}
