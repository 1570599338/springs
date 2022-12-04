package com.lquan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lquan
 * @create 2022- 12-04 下午11:26
 * @description
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private  String userName;
    private  String password;
}
