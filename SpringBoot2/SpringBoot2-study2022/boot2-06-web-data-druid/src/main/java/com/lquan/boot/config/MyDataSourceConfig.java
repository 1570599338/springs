package com.lquan.boot.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @program: springs
 * @description: 自定义数据源的配置
 * @author: lquan
 * @create: 2022-12-14 16:47
 **/

@Configuration
public class MyDataSourceConfig {

    /**
     * 配置druid的数据源
     * @return
     */
    @ConfigurationProperties("spring.datasource")// 直接将配置文件中的信息注入DataSource中
    @Bean
    public DataSource dataSource() throws  Exception{
        DruidDataSource dataSource = new DruidDataSource();
        // 加入监控和防火墙功能
       // dataSource.setFilters("stat,wall"); 在配置文件中进行配置


        return dataSource;
    }


    /**
     * 配置druid的监控页面功能
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        // 配置监控页面访问密码
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");

        return registrationBean;
    }


    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据。
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }




}
