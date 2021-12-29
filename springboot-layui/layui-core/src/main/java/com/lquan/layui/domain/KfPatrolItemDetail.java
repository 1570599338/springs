package com.lquan.layui.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 检查点详情信息(KfPatrolItemDetail)实体类
 *
 * @author easycode
 * @since 2021-12-08 18:07:12
 */
public class KfPatrolItemDetail implements Serializable {
    private static final long serialVersionUID = -94662603467919808L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 巡查点id
     */
    private Integer kfPatrolItemId;
    /**
     * 巡查点描述
     */
    private String itemDescribe;
    /**
     * 巡查方法：
     * 0-现场核查；
     * 1-电话核查；
     */
    private Integer chekcMethod;
    /**
     * 分值
     */
    private Integer itemScore;
    /**
     * 排序
     */
    private Integer itemSort;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 删除标识：
     * 0-未删除；
     * 1-已删除
     */
    private Integer deleteFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人uuid
     */
    private String createUserUuid;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 修改人uuid
     */
    private String modifyUserUuid;
    /**
     * 更新时间
     */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKfPatrolItemId() {
        return kfPatrolItemId;
    }

    public void setKfPatrolItemId(Integer kfPatrolItemId) {
        this.kfPatrolItemId = kfPatrolItemId;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    public Integer getChekcMethod() {
        return chekcMethod;
    }

    public void setChekcMethod(Integer chekcMethod) {
        this.chekcMethod = chekcMethod;
    }

    public Integer getItemScore() {
        return itemScore;
    }

    public void setItemScore(Integer itemScore) {
        this.itemScore = itemScore;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserUuid() {
        return createUserUuid;
    }

    public void setCreateUserUuid(String createUserUuid) {
        this.createUserUuid = createUserUuid;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUserUuid() {
        return modifyUserUuid;
    }

    public void setModifyUserUuid(String modifyUserUuid) {
        this.modifyUserUuid = modifyUserUuid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
