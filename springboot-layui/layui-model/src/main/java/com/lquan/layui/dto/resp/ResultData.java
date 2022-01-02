package com.lquan.layui.dto.resp;

import com.github.pagehelper.PageInfo;
import com.lquan.layui.enums.ResultCodeEnum;
import lombok.Data;

/**
 * 接口返回数据
 *  @author liyujun@9fbank.cc
 *  @date 2019年07月10日
 */
@Data
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private Long count;

    private ResultData(){

    }
    /**
     * 构建失败的消息信息
     * @param code
     * @param message
     */
    public static ResultData bulidFailResult(String code,String message) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

    /**
     * 构建失败的消息信息
     * @param resultCodeEnum
     */
    public static ResultData bulidFailResult(ResultCodeEnum resultCodeEnum) {
        ResultData resultData = new ResultData();
        resultData.setCode(resultCodeEnum.getCode());
        resultData.setMessage(resultCodeEnum.getDesc());
        return resultData;
    }

    /**
     * 构建成功的返回数据
     * @param data 返回数据
     */
    public static <T> ResultData bulidSuccessResult(T data){

        ResultData resultData = new ResultData();
        resultData.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultData.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        resultData.setData(data);
        return resultData;
    }


    /**
     * 构建成功的返回数据
     * @param data 返回数据
     */
    public static <T> ResultData bulidSuccessPageResult(PageInfo<T> data ){

        ResultData resultData = new ResultData();
        resultData.setCode(ResultCodeEnum.SUCCESS_PAGE.getCode());
        resultData.setMessage(ResultCodeEnum.SUCCESS_PAGE.getDesc());
        resultData.setData(data.getList());
        resultData.setCount(data.getTotal());
        return resultData;
    }

}
