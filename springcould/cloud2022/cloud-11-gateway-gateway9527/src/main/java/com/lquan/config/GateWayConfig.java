package com.lquan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-05 19:49
 **/
@Configuration
public class GateWayConfig {

    /**
     *  配置了一个id为route-name的路由规则
     *  当访问地址为http://127.0.0.1：527/news时会自动转发到：https://news.baidu.com/
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu", r -> r.path("/news").uri("https://news.baidu.com/")).build();
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu2", r -> r.path("/fanyi").uri("https://fanyi.baidu.com")).build();
        return routes.build();
    }

}
