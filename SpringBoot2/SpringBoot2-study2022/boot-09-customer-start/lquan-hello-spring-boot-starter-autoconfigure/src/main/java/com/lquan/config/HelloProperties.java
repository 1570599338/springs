package com.lquan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lquan
 * @create 2022- 12-21 下午9:51
 * @description
 */
@ConfigurationProperties("lquan.hello")
public class HelloProperties {

    private String prefix;

    private String suffix;


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
