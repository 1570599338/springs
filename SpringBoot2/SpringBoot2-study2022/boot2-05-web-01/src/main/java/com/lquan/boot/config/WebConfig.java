package com.lquan.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author lquan
 * @create 2022- 11-30 下午7:59
 * @description
 */

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    /**
     * Rest原理（表单提交要使用REST的时候）
     * ● 表单提交会带上_method=PUT
     * ● 请求过来被HiddenHttpMethodFilter拦截
     * @return
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
       //将 表单提交会带上_method=PUT中的_method方法修改成_m
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }


    // 矩阵变量的开启的方法1
    /**
     * 矩阵变量的开启，目的是将patch路径下的"；"不移除。
     * @param configurer
     * 这种方式是需要继承 WebMvcConfigurer 然后重写configurePathMatch方法的
     *
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        // 不移除"；"后面的内容，矩阵变量功能就可以生效
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }


    /**
     * 开启矩阵变量的方法2
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除"；"后面的内容，矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }


}
