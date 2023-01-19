package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-17 10:40
 **/

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class SeataStorageAPP2002{

    public static void main(String[] args){
        SpringApplication.run(SeataStorageAPP2002.class, args);
    }
}

