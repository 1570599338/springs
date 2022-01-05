package com.lquan.layui.domain;

import java.util.Date;
import lombok.ToString;
import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2022-01-05 23:49:39
 */
@ToString
public class Question implements Serializable {
    private static final long serialVersionUID = 688767500200344961L;
    
    private Integer id;
    
    private Integer templateid;
    /**
     * 2;//单选题  3;//多选题 4;//矩阵单选题 5;//矩阵多选题 6;//单行填空题 7;//矩阵打分题 8;//哑题 11;//多项填空题 12;//图片单选题 13;//图片多选题 50;//打分题 60;//排序题 70;//描述说明题 95;//多行填空题
     */
    private Integer type;
    /**
     * 联动题类型； 1 - 省份城市； 2 - 品牌车型
     */
    private Integer subjecttype;
    
    private String number;
    /**
     * 标准化题号
     */
    private String snumber;
    /**
     * 批注
     */
    private String notation;
    
    private String title;
    
    private String imageurl;
    
    private String videourl;
    /**
     * 是否必答，0：否，1：是
     */
    private Integer optional;
    
    private String help;
    /**
     * 显示方式，1：纵向，2：横向，3，列
     */
    private Integer layout;
    
    private Integer dispindex;
    
    private Integer selectionmax;
    
    private Integer selectionmin;
    /**
     * 是否乱序
     */
    private Integer rowdisordered;
    /**
     * 是否可行列转换
     */
    private Integer matrixpivot;
    /**
     * 最后一个选项固定
     */
    private Integer rowlastfixed;
    /**
     * 是否乱序
     */
    private Integer coldisordered;
    /**
     * 最后一个选项固定
     */
    private Integer collastfixed;
    
    private Integer columncount;
    /**
     * 业务类型；101 - 性别；109 - 教育程度
     */
    private Integer businesstype;
    /**
     * tinyint, 1 - star 星星, 2 - number 方块；打分类型
     */
    private Integer scoretype;
    /**
     * 行倒序
     */
    private Integer rowreverse;
    /**
     * 列倒序
     */
    private Integer colreverse;
    /**
     * 图表类型；1 - 饼图  ;  2 - 折线图 ; 3 - 柱状图
     */
    private Integer charttype;
    /**
     * 答下一题时等待时间
     */
    private Integer waitbeforenext;
    /**
     * 1:题目,２:车主字段
     */
    private Integer refersourcetype;
    /**
     * 引用的车主字段，哑题专用
     */
    private String referfieldname;
    /**
     * 哑题专用，引用的questionID
     */
    private Integer referquestionid;
    
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

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubjecttype() {
        return subjecttype;
    }

    public void setSubjecttype(Integer subjecttype) {
        this.subjecttype = subjecttype;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getOptional() {
        return optional;
    }

    public void setOptional(Integer optional) {
        this.optional = optional;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public Integer getDispindex() {
        return dispindex;
    }

    public void setDispindex(Integer dispindex) {
        this.dispindex = dispindex;
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

    public Integer getRowdisordered() {
        return rowdisordered;
    }

    public void setRowdisordered(Integer rowdisordered) {
        this.rowdisordered = rowdisordered;
    }

    public Integer getMatrixpivot() {
        return matrixpivot;
    }

    public void setMatrixpivot(Integer matrixpivot) {
        this.matrixpivot = matrixpivot;
    }

    public Integer getRowlastfixed() {
        return rowlastfixed;
    }

    public void setRowlastfixed(Integer rowlastfixed) {
        this.rowlastfixed = rowlastfixed;
    }

    public Integer getColdisordered() {
        return coldisordered;
    }

    public void setColdisordered(Integer coldisordered) {
        this.coldisordered = coldisordered;
    }

    public Integer getCollastfixed() {
        return collastfixed;
    }

    public void setCollastfixed(Integer collastfixed) {
        this.collastfixed = collastfixed;
    }

    public Integer getColumncount() {
        return columncount;
    }

    public void setColumncount(Integer columncount) {
        this.columncount = columncount;
    }

    public Integer getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(Integer businesstype) {
        this.businesstype = businesstype;
    }

    public Integer getScoretype() {
        return scoretype;
    }

    public void setScoretype(Integer scoretype) {
        this.scoretype = scoretype;
    }

    public Integer getRowreverse() {
        return rowreverse;
    }

    public void setRowreverse(Integer rowreverse) {
        this.rowreverse = rowreverse;
    }

    public Integer getColreverse() {
        return colreverse;
    }

    public void setColreverse(Integer colreverse) {
        this.colreverse = colreverse;
    }

    public Integer getCharttype() {
        return charttype;
    }

    public void setCharttype(Integer charttype) {
        this.charttype = charttype;
    }

    public Integer getWaitbeforenext() {
        return waitbeforenext;
    }

    public void setWaitbeforenext(Integer waitbeforenext) {
        this.waitbeforenext = waitbeforenext;
    }

    public Integer getRefersourcetype() {
        return refersourcetype;
    }

    public void setRefersourcetype(Integer refersourcetype) {
        this.refersourcetype = refersourcetype;
    }

    public String getReferfieldname() {
        return referfieldname;
    }

    public void setReferfieldname(String referfieldname) {
        this.referfieldname = referfieldname;
    }

    public Integer getReferquestionid() {
        return referquestionid;
    }

    public void setReferquestionid(Integer referquestionid) {
        this.referquestionid = referquestionid;
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

