package com.lquan.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lquan
 * @create 2022- 12-06 下午1:49
 * @description
 *          处理整个web Controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class}) //处理异常
    public String handleArithException(Exception e){
        log.error("异常信息：",e);
        return "";// 视图地址
    }
}
