package com.lquan.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author lquan
 * @create 2022- 12-21 上午1:15
 * @description
 */
@Data
@Component
@Profile("mypro")
@ConfigurationProperties("persion")
public class Customer implements Persion {
    private String name;
    private Integer age;
}
