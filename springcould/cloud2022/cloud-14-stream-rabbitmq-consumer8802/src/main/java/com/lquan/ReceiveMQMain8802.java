package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcould
 * @description: mq的生产者
 * @author: lquan
 * @create: 2023-01-11 16:43
 **/
@SpringBootApplication
//@EnableEurekaClient
public class ReceiveMQMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(ReceiveMQMain8802.class,args);
    }
}
