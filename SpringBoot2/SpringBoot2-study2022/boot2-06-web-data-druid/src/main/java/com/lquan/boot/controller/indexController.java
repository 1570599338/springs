package com.lquan.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-14 19:25
 **/
@Slf4j
@RestController
public class indexController {

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    public  String sql(){
        int count = jdbcTemplate.queryForObject("select count(*) from t_order", Integer.class);
        log.info("数量:{}", count);

        return "数量："+count;
    }
}
