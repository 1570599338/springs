package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @program: springcould
 * @description: 模拟服务端超时、异常等情况
 * @author: lquan
 * @create: 2022-12-27 21:27
 **/
@EnableEurekaClient
@SpringBootApplication
public class Pay09Problem8001 {

    public static void main(String[] args) {

        SpringApplication.run(Pay09Problem8001.class,args);
    }
}
