package com.lquan.boot.config;

import com.lquan.boot.bean.Pet;
import com.lquan.boot.converter.LquanMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lquan
 * @create 2022- 11-30 下午7:59
 * @description
 */

@Configuration
public class WebConfig  {

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
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        // 不移除"；"后面的内容，矩阵变量功能就可以生效
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }


    /**
     *  WebMvcconfigurer定制化SpringMVC的功能
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){


        return  new WebMvcConfigurer() {


            //开启矩阵变量的方法2
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除"；"后面的内容，矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            // 添加自定义的参数解析格式： 阿猫，3
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        // 阿猫，3
                        if(!StringUtils.isEmpty(source)){
                            Pet pet = new Pet();
                            String[] splis =source.split(",");
                            pet.setName(splis[0]);
                            pet.setAge(new Integer(splis[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }

            // 添加自定义的消息转换器 messageConverter:application/lquan
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new LquanMessageConverter());
            }

            //

            /**
             * 自定义内容协商器
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json",MediaType.APPLICATION_JSON);
                mediaTypes.put("xml",MediaType.APPLICATION_XML);
                mediaTypes.put("lquan",MediaType.parseMediaType("application/x-lquan"));
                // 指定支持解析那些参数对应的那些媒体类型协商器
                ParameterContentNegotiationStrategy ParaMeterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                /**
                 *  http://127.0.0.1:8080/test/persion?format=json
                 */
                //  ParaMeterStrategy.setParameterName("");//这个地方是将format的url参数名称改成自定义的名称
                // 添加关于请求头的内容协商器
                HeaderContentNegotiationStrategy headertrategy = new HeaderContentNegotiationStrategy();
                // 将请求参数类型的内容协商器和请求头类型的内容协商器全部加入其中
                configurer.strategies(Arrays.asList(ParaMeterStrategy,headertrategy));
            }
        };

    }


}
