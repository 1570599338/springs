package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcould
 * @description:
 *              默认方式回去配置中心的配置信息
 *
 *
 * @author: lquan
 * @create: 2023-01-13 09:43
 *
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Nocas17Config3378 {

    public static void main(String[] args) {
        SpringApplication.run(Nocas17Config3378.class,args);
    }

}
