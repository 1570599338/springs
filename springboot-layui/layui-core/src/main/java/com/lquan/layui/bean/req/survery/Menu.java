package com.lquan.layui.bean.req.survery;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Menu {
    private Integer id;
    private String text;
    private  String icon;
    private List<MenuItem> children;
}
