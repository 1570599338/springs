package com.lquan.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: springs
 * @description: ShiroConfig
 * @author: lquan
 * @create: 2022-01-30 16:06
 **/
@Configuration
public class ShrioConfig {

    /**
     * 创建shiroFilterFactoryBean
     *
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(manager);

        // 设置安全管理器
        /**
         * shiro 内置过滤器，可以实现权限相关的拦截器
         *          常用的过滤器：
         *              anon:无需认证（登录）可以访问
         *              authc：必须认证可以访问
         *              user:如果使用rememberMe的功能可以直接访问
         *              perms:改资源必须得到资源权限才可以访问
         *              role：该资源必须得到角色权限才可以 访问
         */
        Map<String,String> filtMap = new LinkedHashMap();
      //  filtMap.put("/add","authc");
        filtMap.put("/login","anon");// 无需认证可访问

        // 授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        filtMap.put("/add","perms[user:add]");
        filtMap.put("/update","perms[user:update]");

        // 修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置未授权的提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");




        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置shiroDialect，用于thymeleaf和shiro标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }
}
