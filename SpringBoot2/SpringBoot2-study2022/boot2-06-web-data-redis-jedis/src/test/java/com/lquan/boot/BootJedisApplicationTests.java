package com.lquan.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
class BootJedisApplicationTests {

    @Autowired(required = false)
    RedisTemplate<String,String> redisTemplate;

    @Autowired(required = false)
    RedisConnectionFactory redisConnectionFactory;


    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("lquan","20221216");
        String lquan = redisTemplate.opsForValue().get("lquan");

        log.info("redisGet:{}",lquan);

        Class<? extends RedisConnectionFactory> aClass = redisConnectionFactory.getClass();

        log.info("redis的Cli是：{}",aClass);


    }

}
