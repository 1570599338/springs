package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcould
 * @description: 注册中心Eureka
 * @author: lquan
 * @create: 2022-12-23 19:47
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaApp7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp7001.class,args);
    }
}
