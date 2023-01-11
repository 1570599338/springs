package com.lquan.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2022-12-23 12:57
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
   // @LoadBalanced
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();

        /*MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);  //加入text/html类型的支持

        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);  //加入text/html类型的支持
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);// tag6

        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);*/
        return restTemplate;
    }






}
