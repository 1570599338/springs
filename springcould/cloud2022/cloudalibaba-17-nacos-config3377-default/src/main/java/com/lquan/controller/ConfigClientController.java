package com.lquan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcould
 * @description: 获取配置中心nacos的配置信息
 * @author: lquan
 * @create: 2023-01-13 09:45
 **/
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private  String portStr;

    /**
     * 获取信息
     * @return
     */
    @GetMapping(value = "/config/info")
    public  String getConfigInfo(){

        return "端口号："+this.portStr +"  版本信息："+this.configInfo;
    }

}
