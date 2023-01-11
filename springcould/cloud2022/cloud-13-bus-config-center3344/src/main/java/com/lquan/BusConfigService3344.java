package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-08 15:08
 **/
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class BusConfigService3344 {


    public static void main(String[] args) {

        SpringApplication.run(BusConfigService3344 .class,args);

    }
}
