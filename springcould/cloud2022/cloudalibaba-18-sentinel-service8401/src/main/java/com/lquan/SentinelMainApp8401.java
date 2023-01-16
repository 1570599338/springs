package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-16 14:01
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMainApp8401 {

    public static void main(String[] args) {

        SpringApplication.run(SentinelMainApp8401.class,args);
    }
}
