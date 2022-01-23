package com.lquan.bean.resp;



public class ForgetInfo {


    private String forgetPhone;

    private String forgetVerificationCode;


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

