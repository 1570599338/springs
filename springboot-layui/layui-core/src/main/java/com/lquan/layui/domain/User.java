package com.lquan.layui.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 3384122292485592695L;
    private Integer id;
    @NotNull(message = "名称不能为空")
    private String name;

    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}