package com.lquan.quartz.trigger.cron;

import com.lquan.quartz.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @program: springs
 * @description: CronTirgger 可以定义基于 Cron 表达式的调度规则，是最常用的触发器类型
 * @author: lquan
 * @create: 2022-01-19 15:40
 **/
public class CronTriggerDemo {

    public static void main(String[] args)  throws Exception {
        //1、创建JobDetail
        JobBuilder jobBuilder = JobBuilder.newJob(MyJob1.class);
        jobBuilder.withIdentity("jobDaliy","GropDaliy");
        jobBuilder.usingJobData("fname","jobDaliy");
        jobBuilder.usingJobData("price","price:GropDaliy");
        // 实例化JobDetail
        JobDetail jobDetail = jobBuilder.build();


        //2、创建触发方式 每隔5分钟执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * *？");


        // 3、创建Trigger
        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        // 定义名称和分组
        triggerBuilder.withIdentity("Tname：CronInterval","TGroup:CronInterval");
        // 触发方式
        triggerBuilder.withSchedule(cronScheduleBuilder);
        triggerBuilder.startNow();
        Trigger trigger = triggerBuilder.build();



        // 创建容器
        SchedulerFactory factory = new StdSchedulerFactory();
        // 创建scheduler容器
        Scheduler scheduler  = factory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        // 启动  Scheduler 先启动后启动无所谓，只要有 Trigger 到达触发条件，就会执行任务
        scheduler.start();
    }
}
