package com.lquan.quartz.listener.job;

import com.lquan.quartz.job.MyJob1;
import com.lquan.quartz.job.MyJob2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;

/**
 * @program: springs
 * @description: 监听 Job
 * @author: lquan
 * @create: 2022-01-19 16:34
 **/
public class JobListenterDemo {

    public static void main(String[] args) throws SchedulerException {

        // JobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob2.class).withIdentity("job2", "group2").build();

        // Trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "grouptrigger").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        // SchedulerFactory
        SchedulerFactory  factory = new StdSchedulerFactory();

        // Scheduler
        Scheduler scheduler = factory.getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);


        // 创建并注册一个全局的Job Listener
        scheduler.getListenerManager().addJobListener(new MyJobListenter(), EverythingMatcher.allJobs());

        scheduler.start();

    }
}
