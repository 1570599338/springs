package com.lquan.layui.domain;

import java.util.Date;
import lombok.ToString;
import java.io.Serializable;

/**
 * (Queoption)实体类
 *
 * @author makejava
 * @since 2022-01-05 23:55:21
 */
@ToString
public class Queoption implements Serializable {
    private static final long serialVersionUID = -35619662617683364L;
    
    private Integer id;
    
    private Integer questionid;
    
    private String code;
    
    private String title;
    /**
     * 排序题固定项名字
     */
    private String ordertip;
    
    private String imageurl;
    
    private String videourl;
    
    private Integer open;
    
    private String help;
    
    private Integer dispindex;
    /**
     * 选项设置类型
     */
    private Integer blanktype;
    
    private Integer blankmax;
    
    private Integer blankmin;
    
    private Integer blankoptional;
    /**
     * 选项目值
     */
    private Integer value;
    /**
     * 是否排它
     */
    private Integer exclusive;
    /**
     * 是否乱序
     */
    private Integer disordered;
    
    private String thumburl;
    /**
     * 文本域宽度
     */
    private Integer blankrows;
    /**
     * 文本域高度
     */
    private Integer blankcols;
    /**
     * 行选项/列选项标识,1-行选项；2-列选项
     */
    private Integer orientation;
    /**
     * 打分题专用（是否显示分值）1 - top；2 - bottom
     */
    private Integer showvalue;
    /**
     * 打分题专用（是否显示满意）1 - top；2 - bottom
     */
    private Integer showtip;
    /**
     * 打分题专用（是否显示其他）1 - top；2 - bottom
     */
    private Integer showcancel;
    
    private Integer selectionmax;
    
    private Integer selectionmin;
    /**
     * 小数位数
     */
    private Integer decimalplaces;
    /**
     * 哑题专用引用哑题
     */
    private Integer superoption;
    
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

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrdertip() {
        return ordertip;
    }

    public void setOrdertip(String ordertip) {
        this.ordertip = ordertip;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Integer getDispindex() {
        return dispindex;
    }

    public void setDispindex(Integer dispindex) {
        this.dispindex = dispindex;
    }

    public Integer getBlanktype() {
        return blanktype;
    }

    public void setBlanktype(Integer blanktype) {
        this.blanktype = blanktype;
    }

    public Integer getBlankmax() {
        return blankmax;
    }

    public void setBlankmax(Integer blankmax) {
        this.blankmax = blankmax;
    }

    public Integer getBlankmin() {
        return blankmin;
    }

    public void setBlankmin(Integer blankmin) {
        this.blankmin = blankmin;
    }

    public Integer getBlankoptional() {
        return blankoptional;
    }

    public void setBlankoptional(Integer blankoptional) {
        this.blankoptional = blankoptional;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getExclusive() {
        return exclusive;
    }

    public void setExclusive(Integer exclusive) {
        this.exclusive = exclusive;
    }

    public Integer getDisordered() {
        return disordered;
    }

    public void setDisordered(Integer disordered) {
        this.disordered = disordered;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public Integer getBlankrows() {
        return blankrows;
    }

    public void setBlankrows(Integer blankrows) {
        this.blankrows = blankrows;
    }

    public Integer getBlankcols() {
        return blankcols;
    }

    public void setBlankcols(Integer blankcols) {
        this.blankcols = blankcols;
    }

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public Integer getShowvalue() {
        return showvalue;
    }

    public void setShowvalue(Integer showvalue) {
        this.showvalue = showvalue;
    }

    public Integer getShowtip() {
        return showtip;
    }

    public void setShowtip(Integer showtip) {
        this.showtip = showtip;
    }

    public Integer getShowcancel() {
        return showcancel;
    }

    public void setShowcancel(Integer showcancel) {
        this.showcancel = showcancel;
    }

    public Integer getSelectionmax() {
        return selectionmax;
    }

    public void setSelectionmax(Integer selectionmax) {
        this.selectionmax = selectionmax;
    }

    public Integer getSelectionmin() {
        return selectionmin;
    }

    public void setSelectionmin(Integer selectionmin) {
        this.selectionmin = selectionmin;
    }

    public Integer getDecimalplaces() {
        return decimalplaces;
    }

    public void setDecimalplaces(Integer decimalplaces) {
        this.decimalplaces = decimalplaces;
    }

    public Integer getSuperoption() {
        return superoption;
    }

    public void setSuperoption(Integer superoption) {
        this.superoption = superoption;
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

