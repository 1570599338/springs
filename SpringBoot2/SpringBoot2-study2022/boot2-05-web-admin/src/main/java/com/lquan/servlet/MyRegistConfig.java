package com.lquan.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * @author lquan
 * @create 2022- 12-06 下午11:18
 * @description
 *              SpringBoot的中注入原生servlet的方式
 */
@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myRegistrationBean(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }


    @Bean
    public ServletListenerRegistrationBean myServletListenerRegistrationBean(){
        MyListener myListener = new MyListener();

        return new ServletListenerRegistrationBean(myListener);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));

        return filterFilterRegistrationBean;
    }
}
