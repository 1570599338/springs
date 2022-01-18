package com.lquan.quartz.simple;

import com.lquan.quartz.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 */
public class Test {

    public static void main(String[] args) throws SchedulerException {
        // 1、 将Job封装成JobDetail
        JobBuilder jobBuilder = JobBuilder.newJob(MyJob1.class);
        // 设置分组
        jobBuilder.withIdentity("job1","group1");
        // 设置携带的参数JobData
        jobBuilder.usingJobData("fname","liu");
        jobBuilder.usingJobData("price",13.11f);
        // 封装成JobDetail
        JobDetail jobDetail = jobBuilder.build();


        // 2、创建触发器Trigger
        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        // 设置分组和名字
        triggerBuilder.withIdentity("trigger1","group1");
        triggerBuilder.usingJobData("triggerFname","triggerFname");
        triggerBuilder.usingJobData("triggerPrice",1314f);
        // 设置触发器的种类
        // 2.1 设置触发器的出发方式
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        triggerBuilder.withSchedule(simpleScheduleBuilder);
        triggerBuilder.startNow();
        Trigger trigger = triggerBuilder.build();


        // 3、 创建Scheduler
        /**
         * Scheduler 先启动后启动无所谓，只要有 Trigger 到达触发条件，就会执行任务
         */
        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler scheduler = factory.getScheduler();
        // 把 JobDetail 和 Trigger 绑定，注册到容器中。
        scheduler.scheduleJob(jobDetail,trigger);
        //Scheduler 先启动后启动无所谓，只要有 Trigger 到达触发条件，就会执行任务
        scheduler.start();



    }
}
