package com.lquan;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-27 20:26
 **/
@EnableCircuitBreaker //激活
@EnableEurekaClient
@SpringBootApplication
public class Paymen8004HF09 {
    public static void main(String[] args) {
        SpringApplication.run(Paymen8004HF09.class,args);
    }

    @Bean
    public ServletRegistrationBean getServlet (){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean ( streamServlet );
        registrationBean.setLoadOnStartup ( 1 );
        registrationBean.addUrlMappings ( "/hystrix.stream" );
        registrationBean.setName ( "HystrixMetricsStreamServlet" );
        return registrationBean ;
    }
}
