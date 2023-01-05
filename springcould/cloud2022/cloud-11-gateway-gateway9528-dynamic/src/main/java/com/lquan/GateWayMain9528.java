package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-05 18:50
 **/
@EnableEurekaClient
@SpringBootApplication
public class GateWayMain9528 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9528.class,args);
    }
}
