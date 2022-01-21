package com.lquan.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @program: springs
 * @description: 任务工厂JobFactory  解决SpringBoot不能在Quartz中注入Bean的问题
 * @author: lquan
 * @create: 2022-01-21 09:01
 **/
@Component
public class JobFactory extends AdaptableJobFactory {

    /**
     * AutowireCapableBeanFactory接口是BeanFactory的子类，
     * 可以连接和填充那些生命周期不被Spring管理的已存在的bean实例
     */
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    /**
     * 创建Job实例
     * @param bundle
     * @return
     * @throws Exception
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        // 实例化job
        Object objectInstance = super.createJobInstance(bundle);
        // 实例job进行注入（Spring管理该Bean）
        autowireCapableBeanFactory.autowireBean(objectInstance);

        return objectInstance;
    }
}
