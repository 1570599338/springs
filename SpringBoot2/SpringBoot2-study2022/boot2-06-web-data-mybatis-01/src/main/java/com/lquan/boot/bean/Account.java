package com.lquan.boot.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 15:49
 **/

@Data
@ToString
public class Account {
    private  Long id;
    private String userId;
    private int money;
}
