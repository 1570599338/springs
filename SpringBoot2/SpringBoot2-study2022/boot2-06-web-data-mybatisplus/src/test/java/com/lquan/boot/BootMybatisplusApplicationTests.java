package com.lquan.boot;

import com.lquan.boot.bean.User;
import com.lquan.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class BootMybatisplusApplicationTests {

    @Autowired(required = false)
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(2l);
        log.info("用户表信息：{}",user);
    }

}
