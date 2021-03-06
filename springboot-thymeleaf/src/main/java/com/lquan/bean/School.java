package com.lquan.bean;

import lombok.Data;

/**
 * @program: springs
 * @description: 测试类
 * @author: lquan
 * @create: 2022-02-16 16:44
 **/
@Data
public class School {
    private Integer Id;
    private String  name;
    private String email;
    private String adress;
    private Student student;

}
