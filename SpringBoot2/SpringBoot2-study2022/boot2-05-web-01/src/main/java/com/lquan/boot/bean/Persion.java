package com.lquan.boot.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lquan
 * @create 2022- 12-03 下午2:47
 * @description
 */
@Data
@ToString
public class Persion {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
