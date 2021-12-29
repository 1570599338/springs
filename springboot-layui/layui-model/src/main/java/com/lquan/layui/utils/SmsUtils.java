package com.lquan.layui.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.kaishun.study.config.SmsConfigure;
import com.kaishun.study.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName:    AliyunSms
 * Package:    com.kaishun.study.sms
 * Description:
 * Datetime:    2020/3/1   16:13
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component
public class SmsUtils {

    @Autowired
    private SmsConfigure smsConfigure;

    @Autowired
    private RedisService redisService;

    /**
     * @description 发送短信
     * @author zhoukaishun
     * @date 2020/3/1 17:19
     */
    public String sendMsg(String phoneNumber , String templateParam) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
                smsConfigure.getRegionId(),          // 地域ID
                smsConfigure.getAccessKeyID(),      // RAM账号的AccessKey ID
                smsConfigure.getAccessKeySecret()); // RAM账号AccessKey Secret
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", smsConfigure.getSignName());
        request.putQueryParameter("TemplateCode", smsConfigure.getTemplateCode());
        request.putQueryParameter("TemplateParam", "{\"code\":\""+templateParam+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            redisService.set(phoneNumber,templateParam,300);
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @description 生成n位的验证码
     * @author zhoukaishun
     * @date 2020/3/1 17:28
     */
    public String randomNumeric(int n){
        return RandomStringUtils.randomNumeric(n);
    }

    /**
     * @description 校检验证码
     * @author zhoukaishun
     * @date 2020/3/1 17:38
     */
    public boolean verification(String phoneNumber , String code){
        boolean flag = false;
        String checkCode = redisService.get(phoneNumber);
        if(!StringUtils.isBlank(checkCode) && checkCode.equals(code)){
            flag = true;
            redisService.delete(phoneNumber);
        }
        return flag;

    }


}
