package com.lquan.layui.dto.resp;

import com.github.pagehelper.PageInfo;
import com.lquan.layui.enums.ResultCodeEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口返回数据
 *  @author liyujun@9fbank.cc
 *  @date 2019年07月10日
 */
@Data
public class ResultSurveryData<T> {
    private String code;
    private T token;
    private String message;
    private T data;

    private List<String> errors;
    private T objs;



    /**
     * 构建成功的返回数据
     * @param data 返回数据
     */
    public static <T> ResultSurveryData bulidSuccessPageResult(T data ){

        ResultSurveryData resultData = new ResultSurveryData();
        resultData.setCode(ResultCodeEnum.SUCCESS_PAGE.getCode());
        resultData.setMessage(ResultCodeEnum.SUCCESS_PAGE.getDesc());
        resultData.setData(data);
        resultData.setObjs(data);
        resultData.setToken(data);
        resultData.setErrors(new ArrayList<>());


        return resultData;
    }

    private ResultSurveryData(){

    }
    /**
     * 构建失败的消息信息
     * @param code
     * @param message
     */
    public static ResultSurveryData bulidFailResult(String code, String message) {
        ResultSurveryData resultData = new ResultSurveryData();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

    /**
     * 构建失败的消息信息
     * @param resultCodeEnum
     */
    public static ResultSurveryData bulidFailResult(ResultCodeEnum resultCodeEnum) {
        ResultSurveryData resultData = new ResultSurveryData();
        resultData.setCode(resultCodeEnum.getCode());
        resultData.setMessage(resultCodeEnum.getDesc());
        return resultData;
    }

    /**
     * 构建成功的返回数据
     * @param data 返回数据
     */
    public static <T> ResultSurveryData bulidSuccessResult(T data){

        ResultSurveryData resultData = new ResultSurveryData();
        resultData.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultData.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        resultData.setData(data);
        return resultData;
    }




}
