package com.lquan.layui.domain;

import java.util.Date;
import lombok.ToString;
import java.io.Serializable;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2022-01-05 01:11:37
 */
@ToString
public class Project implements Serializable {
    private static final long serialVersionUID = -53598506110416348L;
    
    private Integer id;
    
    private String number;
    
    private String name;
    
    private Integer type;
    
    private Date begindate;
    
    private Date enddate;
    
    private String director;
    
    private String mebers;
    /**
     * 1 - stop；2 - running
     */
    private Integer quotaservicestate;
    
    private String remark;
    /**
     * 项目状态;0-初始，1-进行中，2-冻结，3-结束
     */
    private Integer state;
    
    private Integer active;
    
    private Date createdat;
    
    private String createdby;
    
    private Date updatedat;
    
    private String updatedby;


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

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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

    public Integer getQuotaservicestate() {
        return quotaservicestate;
    }

    public void setQuotaservicestate(Integer quotaservicestate) {
        this.quotaservicestate = quotaservicestate;
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

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

}

