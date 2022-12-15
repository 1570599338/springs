package com.lquan.boot.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 18:13
 **/
@Data
@ToString
public class City {

    private Long id;
    private String name;
    private String state;
    private String country;

}
