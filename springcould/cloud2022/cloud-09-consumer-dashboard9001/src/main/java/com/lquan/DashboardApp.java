package com.lquan;

/**
 * @author lquan
 * @create 2023- 01-05 上午12:16
 * @description
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApp {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApp.class,args);

    }
}
