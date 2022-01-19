package com.lquan.quartz.listener.scheduler;

import com.lquan.quartz.job.MyJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @program: springs
 * @description: 测试方法
 * @author: lquan
 * @create: 2022-01-19 18:04
 **/
public class SchedulerListenerDemo {

    public static void main(String[] args) throws SchedulerException {

        // JobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob2.class).withIdentity("job1", "group1").build();

        // Trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        // SchedulerFactory
        SchedulerFactory  factory = new StdSchedulerFactory();

        // Scheduler
        Scheduler scheduler = factory.getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);

        // 创建Scheduler Listener
        scheduler.getListenerManager().addSchedulerListener(new MySchedulerListener());

        scheduler.start();

    }

}
