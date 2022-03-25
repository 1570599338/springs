package com.lquan.entry;

import lombok.ToString;

import javax.persistence.*;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 19:38
 *
 * jpa 成功一半
 **/

@ToString
@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable = false,length = 100)
    private  String name;

    @Column(nullable = false,length = 200)
    private  String address;
}
