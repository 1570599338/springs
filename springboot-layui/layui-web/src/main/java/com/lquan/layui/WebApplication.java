package com.lquan.layui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class WebApplication {


        public static void main(String[] args) {
            SpringApplication.run(WebApplication.class, args);
        }


}
