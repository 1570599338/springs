package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-23 21:53
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaClusterApp7001 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterApp7001.class,args);
    }
}
