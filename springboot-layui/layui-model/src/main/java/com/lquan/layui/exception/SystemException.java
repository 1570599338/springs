package com.lquan.layui.exception;

import com.lquan.layui.enums.ResultCodeEnum;
import com.lquan.layui.enums.ResultEnum;

/**
 * ClassName:    SystemException
 * Package:    com.kaishun.study.exception
 * Description:
 * Datetime:    2020/2/18   12:31
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class SystemException extends CodeMessageException{


    public SystemException(ResultEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    /**
     * @description 自定义错误描述和错误码
     * @author zhoukaishun
     * @date 2020/2/18 12:35
     */
    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @description 自定义错误描述
     * @author zhoukaishun
     * @date 2020/2/18 12:35
     */
    public SystemException(String message) {
        super(message);
        this.code = ResultEnum.SERVER_ERROR.getCode();
    }


}
