package com.lquan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lquan
 * @create 2022- 11-27 上午12:59
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dog {

    /**
     * name : dog
     * age : 12
     */

    private String name;
    private int age;


}
