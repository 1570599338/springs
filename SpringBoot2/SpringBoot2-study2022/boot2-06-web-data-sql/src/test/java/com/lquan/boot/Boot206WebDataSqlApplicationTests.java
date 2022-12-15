package com.lquan.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot206WebDataSqlApplicationTests {

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        int count = jdbcTemplate.queryForObject("select count(*) from t_order", Integer.class);
        log.info("数量:{}", count);

    }


}
