package com.lquan.layui.bean.resp;


import com.lquan.layui.validator.Password;
import com.lquan.layui.validator.Phone;

public class ForgetInfo {

    @Phone
    private String forgetPhone;

    private String forgetVerificationCode;

    @Password
    private String newPassword;

    public String getForgetPhone() {
        return forgetPhone;
    }

    public void setForgetPhone(String forgetPhone) {
        this.forgetPhone = forgetPhone;
    }

    public String getForgetVerificationCode() {
        return forgetVerificationCode;
    }

    public void setForgetVerificationCode(String forgetVerificationCode) {
        this.forgetVerificationCode = forgetVerificationCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

