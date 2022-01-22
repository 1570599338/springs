package com.lquan.config;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * @program: springs
 * @description: 任务调度器 Scheduler
 * @author: lquan
 * @create: 2022-01-21 09:16
 **/
@Configuration
public class QuartzConfig {

    // 配置文件路径
    private static final String QUARTZ_CONFIG = "/quartz.properties";


    @Autowired
    private  JobFactory jobFactory;

   /* public QuartzConfig(JobFactory jobFactory) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   jobFactory = [" + jobFactory + "]");
        this.jobFactory = jobFactory;
    }*/

    /**
     * 从quartz.properties文件中读取Quartz配置属性
     * @return
     * @throws IOException
     */
    @Bean
    public Properties quartzProperties() {
        try {
            PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
            propertiesFactoryBean.setLocation(new ClassPathResource(QUARTZ_CONFIG));
            propertiesFactoryBean.afterPropertiesSet();
            return propertiesFactoryBean.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

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
        //factory.setJobFactory(jobFactory);

       // factory.setAutoStartup(true);//设置自行启动
        //可选,QuartzScheduler启动时更新己存在的Job,这样就不用每次修改targetObject后删除qrtz_job_details表对应记录
        //factory.setOverwriteExistingJobs(true);
        // 设置覆盖已存在的任务
        factory.setOverwriteExistingJobs(true);
        factory.setQuartzProperties(quartzProperties());
        factory.setJobFactory(jobFactory);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        //这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。
        factory.setWaitForJobsToCompleteOnShutdown(true);
        //factory.setOverwriteExistingJobs(false);//是否覆盖己存在的Job
        factory.setStartupDelay(10);//QuartzScheduler 延时启动，应用启动完后 QuartzScheduler 再启动




        return factory;
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() {

        return schedulerFactoryBean().getScheduler();
    }


}
