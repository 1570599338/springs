package com.lquan.layui.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 巡查检查项信息(KfPatrolItemInfo)实体类
 *
 * @author easycode
 * @since 2021-12-08 18:06:57
 */
public class KfPatrolItemInfo implements Serializable {
    private static final long serialVersionUID = -50349994580067010L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 租户id
     */
    private Integer busBusinessId;
    /**
     * 巡查场景类型：
     * 0-岗位服务；
     * 1-展示区服务；
     * 2-防疫服务；
     */
    private Integer patrolSceneType;
    /**
     * 检查点名称
     */
    private String itemName;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 至根节点的距离
     */
    private Integer rootDepth;
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

    public Integer getBusBusinessId() {
        return busBusinessId;
    }

    public void setBusBusinessId(Integer busBusinessId) {
        this.busBusinessId = busBusinessId;
    }

    public Integer getPatrolSceneType() {
        return patrolSceneType;
    }

    public void setPatrolSceneType(Integer patrolSceneType) {
        this.patrolSceneType = patrolSceneType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getRootDepth() {
        return rootDepth;
    }

    public void setRootDepth(Integer rootDepth) {
        this.rootDepth = rootDepth;
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
