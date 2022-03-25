package com.lquan.entry;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @program: springs
 * @description: 实体类
 * @author: lquan
 * @create: 2022-03-25 15:49
 *
 * @Entity 当前的类是实体类，并且接受spring date jpa的控制管理，对应数据库里面的一张表。
 *          如果不去配置的话，就会默认对应的数据库中的user这张表
 *
 * @Table 指定对应的表，name就是对应的表明
 *
 **/
@Data
@ToString
@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable = false,length = 32)//name不为空 长度32
    private String name;
    private int age;

    @Column(nullable = false,unique = true,length = 32)//name不为空 长度32
    private String IDs;//身份证号

    @Column(length = 512)
    private String address ;

}
