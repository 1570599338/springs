package com.lquan.layui.bean.resp.survery;

import com.lquan.layui.bean.req.survery.MenuItem;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MenuResult {
    private Integer id;
    private String text;
    private  String icon;
    private String url;
    private  String target;
    private List<MenuResult> children;

}
