package com.lquan.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author lquan
 * @create 2022- 12-21 上午1:17
 * @description
 */
@Data
@Component
@ConfigurationProperties("persion")
public class Student {
    private String name;
    private Integer age;
}
