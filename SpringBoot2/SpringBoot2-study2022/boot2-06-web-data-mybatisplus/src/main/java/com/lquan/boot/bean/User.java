package com.lquan.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
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
//@TableName("user")// 默认情况是表名和bean是一样的，如果不一样的话，可以使用该注解进行映射
public class User {

    @TableField(exist =false )// 批注字段在表中不存在
    private  String userName;
    @TableField(exist =false )// 批注字段在表中不存在
    private  String password;

// 一下是表user的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
