package com.lquan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-16 14:02
 **/
@Slf4j
@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }


    /**
     * 服务降级
     * @return
     */
    @GetMapping("/testD")
    public String testD(){
        // 暂停几秒钟的时间
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

        return "------testD";
    }


}