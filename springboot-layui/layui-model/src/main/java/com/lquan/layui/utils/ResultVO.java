package com.lquan.layui.utils;

import lombok.Data;

/**
 * ClassName:    ResultVO
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/2/14   12:57
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
public class ResultVO<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 状态
     */
    private String status;
    /**
     * 条数
     */
    private Integer count;
    /**
     * 返回值
     */
    private T data;
    /**
     * 跳转url
     */
    private String url;
}
