package com.lquan.layui.domain;

import java.util.Date;
import lombok.ToString;
import java.io.Serializable;

/**
 * (Template)实体类
 *
 * @author lquan
 * @since 2022-01-05 16:45:43
 */
@ToString
public class Template implements Serializable {
    private static final long serialVersionUID = -32263253266540946L;
    
    private Integer id;
    
    private Integer projectid;
    
    private String name;
    /**
     * 别名
     */
    private String alias;
    
    private String remark;
    /**
     * 1:未发布，2：已发布，3：……
     */
    private Integer state;
    /**
     * 作用说明
     */
    private String guide;
    /**
     * 是否显示欢迎语/协议
     */
    private Integer signagreement;
    /**
     * 优先级
     */
    private Integer rank;
    
    private Integer goback;
    /**
     * 答卷人员类型；1: Non-evalator only，只允许非评估员答卷2： evaluator only,只允许评估员答卷 3 : mixed都可以答卷
     */
    private Integer participantmask;
    /**
     * 答下一题时等待时间
     */
    private Integer waitbeforenext;
    
    private String logourl1;
    
    private String logourl2;
    /**
     * 检查是否显示配额
     */
    private Integer checked;
    /**
     * 手机端答题总数
     */
    private Integer answercount;
    /**
     * 总分计算表达式
     */
    private String totalexp;
    /**
     * 线下项目； 0 - 不是线下；1 - 线下
     */
    private Integer offline;
    /**
     * 是否添加身份证号：0不添加；1添加
     */
    private Integer idcard;
    /**
     * 身份证号添加显示位置：0不显示；1答题前；2答题后
     */
    private Integer idcardlocation;
    
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

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Integer getSignagreement() {
        return signagreement;
    }

    public void setSignagreement(Integer signagreement) {
        this.signagreement = signagreement;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getGoback() {
        return goback;
    }

    public void setGoback(Integer goback) {
        this.goback = goback;
    }

    public Integer getParticipantmask() {
        return participantmask;
    }

    public void setParticipantmask(Integer participantmask) {
        this.participantmask = participantmask;
    }

    public Integer getWaitbeforenext() {
        return waitbeforenext;
    }

    public void setWaitbeforenext(Integer waitbeforenext) {
        this.waitbeforenext = waitbeforenext;
    }

    public String getLogourl1() {
        return logourl1;
    }

    public void setLogourl1(String logourl1) {
        this.logourl1 = logourl1;
    }

    public String getLogourl2() {
        return logourl2;
    }

    public void setLogourl2(String logourl2) {
        this.logourl2 = logourl2;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getAnswercount() {
        return answercount;
    }

    public void setAnswercount(Integer answercount) {
        this.answercount = answercount;
    }

    public String getTotalexp() {
        return totalexp;
    }

    public void setTotalexp(String totalexp) {
        this.totalexp = totalexp;
    }

    public Integer getOffline() {
        return offline;
    }

    public void setOffline(Integer offline) {
        this.offline = offline;
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public Integer getIdcardlocation() {
        return idcardlocation;
    }

    public void setIdcardlocation(Integer idcardlocation) {
        this.idcardlocation = idcardlocation;
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

