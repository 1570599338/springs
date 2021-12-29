package com.lquan.layui.domain;

import java.io.Serializable;

/**
 * 检查项父子深度表(KfPatrolItemPath)实体类
 *
 * @author easycode
 * @since 2021-12-09 09:56:14
 */
public class KfPatrolItemPath implements Serializable {
    private static final long serialVersionUID = -98221125762858009L;
    /**
     * 父
     */
    private Integer ancestor;
    /**
     * 子
     */
    private Integer descendant;
    /**
     * 深度
     */
    private Integer depth;


    public Integer getAncestor() {
        return ancestor;
    }

    public void setAncestor(Integer ancestor) {
        this.ancestor = ancestor;
    }

    public Integer getDescendant() {
        return descendant;
    }

    public void setDescendant(Integer descendant) {
        this.descendant = descendant;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

}
