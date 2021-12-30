package com.lquan.layui.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:    SmsAccessKeyID
 * Description:
 */
@Component
@ConfigurationProperties(prefix="smsconfigure")
@Data
public class SmsConfigure {

    private String regionId;

    private String accessKeyID;

    private String accessKeySecret;
    /**
     * 签名
     */
    private String signName;
    /**
     * 模板
     */
    private String templateCode;
}
