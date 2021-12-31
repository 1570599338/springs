package com.lquan.layui.utills;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.lquan.layui.config.SmsConfigure;
import com.lquan.layui.utils.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:    AliyunSms
 * Package:    com.kaishun.study.sms
 * Description:
 * Datetime:    2020/3/1   16:13
 * Author:   zhoukaishun
 */
@Component
public class SmsUtils {

    @Autowired
    private SmsConfigure smsConfigure;


    @Autowired
    private StringRedisTemplate redisTemplate;


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
            redisTemplate.opsForValue().set(phoneNumber,templateParam,300, TimeUnit.SECONDS);
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
        String checkCode = phoneNumber == null ? null : (String)this.redisTemplate.opsForValue().get(phoneNumber);//redisService.get(phoneNumber);
        if(!StringUtils.isBlank(checkCode) && checkCode.equals(code)){
            flag = true;
           // redisService.delete(phoneNumber);
            redisTemplate.delete(phoneNumber);
        }
        return flag;

    }


}
