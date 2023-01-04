package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-27 20:26
 *          hystrix的熔断Case
 **/
@EnableCircuitBreaker //激活
@EnableEurekaClient
@SpringBootApplication
public class Paymen8003HF09 {
    public static void main(String[] args) {
        SpringApplication.run(Paymen8003HF09.class,args);
    }
}
