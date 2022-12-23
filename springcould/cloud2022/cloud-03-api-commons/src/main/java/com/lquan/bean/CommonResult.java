package com.lquan.bean;

import lombok.Data;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-22 19:48
 **/
@Data
public class CommonResult<T> {
    // 状态码
    private Integer code;
    // 消息
    private String message;
    // 数据传输
    private T date;


    public CommonResult() {
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }
}
