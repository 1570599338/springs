package com.lquan.bean;

import lombok.ToString;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author lquan
 * @since 2022-12-22 19:44:23
 */
@ToString
public class Payment implements Serializable {
    private static final long serialVersionUID = -89200327775006604L;
    /**
     * id
     */
    private Long id;

    private String serial;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}