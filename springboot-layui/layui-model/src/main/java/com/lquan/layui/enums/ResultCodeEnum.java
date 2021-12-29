package com.lquan.layui.enums;

public enum ResultCodeEnum {

    /**
     * 返回值枚举code
     */
    SUCCESS("2000","成功"),
    FAIL("5000", "失败"),
    SYS_ERROR("5001","系统繁忙，请稍后重试");



    ResultCodeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }

}
