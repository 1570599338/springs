package com.lquan.layui.bean.resp.survery;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2022-01-05 01:11:37
 */
@ToString
public class ProjectResult implements Serializable {
    private static final long serialVersionUID = -53598506110416348L;
    
    private Integer id;
    
    private String number;
    
    private String name;
    
    private Integer type;

  //  @DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
   @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date beginDate;

  //  @DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date endDate;
    
    private String director;
    
    private String mebers;
    /**
     * 1 - stop；2 - running
     */
    private Integer quotaServiceState;
    
    private String remark;
    /**
     * 项目状态;0-初始，1-进行中，2-冻结，3-结束
     */
    private Integer state;
    
    private Integer active;
    
    private Date createdAt;
    
    private String createdBy;
    
    private Date updatedAt;
    
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMebers() {
        return mebers;
    }

    public void setMebers(String mebers) {
        this.mebers = mebers;
    }

    public Integer getQuotaServiceState() {
        return quotaServiceState;
    }

    public void setQuotaServiceState(Integer quotaServiceState) {
        this.quotaServiceState = quotaServiceState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

