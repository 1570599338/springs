package com.lquan.layui.bean.resp;

import java.util.List;

/**
 * ClassName:    RoleMenuResult
 * Package:    com. study.Result
 * Description:
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class RoleMenuResult {

    private List<MenuTreeResult> list;

    public List<MenuTreeResult> getList() {
        return list;
    }

    public void setList(List<MenuTreeResult> list) {
        this.list = list;
    }
}
