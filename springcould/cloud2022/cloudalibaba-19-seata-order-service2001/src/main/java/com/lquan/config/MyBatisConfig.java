package com.lquan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-17 16:11
 **/
@Configuration
@MapperScan({"com.lquan.mapper"})
public class MyBatisConfig {
}
