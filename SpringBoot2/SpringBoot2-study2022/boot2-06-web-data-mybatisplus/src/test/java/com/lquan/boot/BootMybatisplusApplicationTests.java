package com.lquan.boot;

import com.lquan.boot.bean.User;
import com.lquan.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
class BootMybatisplusApplicationTests {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    RedisTemplate<String,String> redisTemplate;

    @Autowired(required = false)
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(2l);
        log.info("用户表信息：{}",user);
    }

    @Test
    void testredis() {

        redisTemplate.opsForValue().set("lquan","20221216");
        String lquan = redisTemplate.opsForValue().get("lquan");

        log.info("redisGet:{}",lquan);

        Class<? extends RedisConnectionFactory> aClass = redisConnectionFactory.getClass();

        log.info("redis的Cli是：{}",aClass);


    }

}
