package com.lquan.layui.domain;

import java.io.Serializable;

/**
 * (TbRole)实体类
 *
 * @author makejava
 * @since 2020-02-25 12:47:29
 */
public class TbRole implements Serializable {
    private static final long serialVersionUID = 668763132481364075L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 备注
    */
    private String remake;
    
    private String createTime;
    
    private String updateTime;
    
    private String updateUser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}