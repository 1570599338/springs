package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcould
 * @description: alibabacloud
 * @author: lquan
 * @create: 2023-01-12 09:15
 **/

@EnableDiscoveryClient
@SpringBootApplication
public class AliPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AliPaymentMain9001.class,args);
    }
}
