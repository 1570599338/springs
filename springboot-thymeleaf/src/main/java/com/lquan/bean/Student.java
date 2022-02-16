package com.lquan.bean;

import lombok.Data;

/**
 * @program: springs
 * @description: 测试类
 * @author: lquan
 * @create: 2022-02-16 16:44
 **/
@Data
public class Student {
    private Integer Id;
    private String  name;
    private int age;
    private String email;

    public Student(Integer id, String name, int age, String email) {
        Id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Student() {
    }
}
