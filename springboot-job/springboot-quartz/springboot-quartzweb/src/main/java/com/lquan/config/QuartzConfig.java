package com.lquan.config;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @program: springs
 * @description: 任务调度器 Scheduler
 * @author: lquan
 * @create: 2022-01-21 09:16
 **/
@Configuration
public class QuartzConfig {


    @Autowired
    private  JobFactory jobFactory;

   /* public QuartzConfig(JobFactory jobFactory) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   jobFactory = [" + jobFactory + "]");
        this.jobFactory = jobFactory;
    }*/

    /**
     * 配置SchedulerFactoryBean 将一个方法产生的Bean并交给Spring容器管理
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        // Spring提供SchedulerFactoryBean为Scheduler提供配置信息,并被Spring容器管理其生命周期
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 设置自定义Job Factory，用于Spring管理Job bean
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   jobFactory = [" + jobFactory + "]");
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() {

        return schedulerFactoryBean().getScheduler();
    }


}
