package com.lquan.boot.config;

import com.lquan.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lquan
 * @create 2022- 12-05 上午1:42
 * @description
 *       1、编写一个拦截器实现handleInterceptor接口
 *       2、拦截器注册到容器中(实现webMVCConfig的addInterceptors)
 *       3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 *
 * @EnableWebMvc:  全面接管
 *                  1、静态资源？视图解析器、欢迎页面……全部失效
 *
 */
//@EnableWebMvc // 全面接管springmvc
@Configuration
public class AdminConfig implements WebMvcConfigurer {


    /**
     * 1、编写一个拦截器实现handleInterceptor接口
     * 2、拦截器注册到容器中(实现webMVCConfig的addInterceptors)
     * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")// 所有请求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**","/aa/**");//放行的请求
    }

    /**
     * 自定义静态资源行为
     *
     * @param registry
     * @see ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 访问 /aa/** 所有请求都去classpath:/static/下面进行匹配
         */
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }
}
