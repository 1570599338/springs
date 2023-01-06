package com.lquan;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @program: springcould
 * @description: 时区测试
 * @author: lquan
 * @create: 2023-01-06 17:09
 **/
public class Test {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
       // ZoneId zone = zonedDateTime.getZone();
        System.out.println(zonedDateTime);
    }
}
