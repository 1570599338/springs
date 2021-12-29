package com.lquan.layui.domain;

import java.util.Date;
import lombok.ToString;
import java.io.Serializable;

/**
 * (TbCourse)实体类
 *
 * @author makejava
 * @since 2021-12-29 16:29:43
 */
@ToString
public class TbCourse implements Serializable {
    private static final long serialVersionUID = 387347570130335993L;
    
    private Long id;
    
    private Long userId;
    
    private String course;
    
    private Integer cut;
    
    private String remark;
    
    private Integer isDelete;
    
    private Date createTime;
    
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getCut() {
        return cut;
    }

    public void setCut(Integer cut) {
        this.cut = cut;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

