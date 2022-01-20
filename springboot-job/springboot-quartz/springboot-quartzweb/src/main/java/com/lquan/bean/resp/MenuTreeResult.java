package com.lquan.bean.resp;

import java.util.List;

/**
 * ClassName:    MenuTreeResult
 * Package:    com.kaishun.study.Result
 * Description:
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class MenuTreeResult {

    private String id;

    private String title;

    private boolean checked = false;

    private List<MenuTreeResult> children;
    public MenuTreeResult(){}
    public MenuTreeResult(String id, String title, List<MenuTreeResult> children) {
        this.id = id;
        this.title = title;
        this.children = children;
    }

    public MenuTreeResult(String id, String title, boolean checked) {
        this.id = id;
        this.title = title;
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<MenuTreeResult> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeResult> children) {
        this.children = children;
    }
}
