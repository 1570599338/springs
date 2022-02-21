package com.lquan.domain;

import com.lquan.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 关于我们对象 t_wish
 *
 * @author lquan
 * @date 2022-02-21
 */
public class Wish {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String title;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String imgurl;

    /**
     * 愿望简介
     */
    @Excel(name = "愿望简介")
    private String wishShort;

    /**
     * 愿望简介
     */
    @Excel(name = "愿望简介")
    private String wishInfo;

    /**
     * 愿望类型 0:代表金钱；1：人力物力
     */
    @Excel(name = "愿望类型 0:代表金钱；1：人力物力")
    private Integer wishType;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;


    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setWishShort(String wishShort) {
        this.wishShort = wishShort;
    }

    public String getWishShort() {
        return wishShort;
    }

    public void setWishInfo(String wishInfo) {
        this.wishInfo = wishInfo;
    }

    public String getWishInfo() {
        return wishInfo;
    }

    public void setWishType(Integer wishType) {
        this.wishType = wishType;
    }

    public Integer getWishType() {
        return wishType;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    /**
     * 请求参数
     */
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
