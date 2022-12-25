package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Cloud04EurekaClusterServer7003Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud04EurekaClusterServer7003Application.class, args);
    }

}
