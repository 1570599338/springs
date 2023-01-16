package com.lquan.domain;

import java.math.BigDecimal;
import lombok.ToString;
import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2023-01-17 02:52:41
 */
@ToString
public class Account implements Serializable {
    private static final long serialVersionUID = 198159722438333769L;
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 已用余额
     */
    private BigDecimal used;
    /**
     * 剩余可用额度
     */
    private BigDecimal residue;


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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public BigDecimal getResidue() {
        return residue;
    }

    public void setResidue(BigDecimal residue) {
        this.residue = residue;
    }

}

