package com.lquan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-08 16:04
 **/
@RestController
@RefreshScope
public class  ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }



    @Autowired
    private RestTemplate restTemplate;

    /**
     * 配置文件动态刷新問題，
     *          1、修改配置文件後，需要運維人員手動請求  curl -X POST "http://localhost:3356/actuator/refresh" 修改的配置文件才能生效
     *          2、所以想利用restTemple來做個post請求
     *          3、結果沒有實現，尷尬了
     *
     *          但是思路是對的，以後有時間在處理吧，此處做一個標記20230108
     * @return
     */
    @GetMapping("/refresh")
    public String getRefresh(){
        List<String> list = new ArrayList<String>();
        restTemplate.postForObject("http://localhost:3356/actuator/refresh",null, list.getClass());
        return configInfo;
    }
}
