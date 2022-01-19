package com.lquan.quartz.trigger.calendarInterval;

import com.lquan.quartz.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @program: springs
 * @description: CalendarIntervalTrigger 可以定义更多时间单位的调度需求，精确到秒
 *                   好处是不需要去计算时间间隔，比如 1 个小时等于多少毫秒。
 *                   例如每年、每个月、每周、每天、每小时、每分钟、每秒。
 *                   每年的月数和每个月的天数不是固定的，这种情况也适用
 * @author: lquan
 * @create: 2022-01-19 10:46
 **/
public class CalendarIntervalTriggerDemo {

    public static void main(String[] args) throws SchedulerException {
        // 1、创建job
        JobBuilder jobBuilder = JobBuilder.newJob(MyJob1.class);
        // 设置分组和名称
        jobBuilder.withIdentity("calendarInterval_Job","calendarIntervalGroup");
        // 实例参数
        jobBuilder.usingJobData("Jname","Jname:calendarIntervalJOB");
        // 创建Jobdetail
        JobDetail jobDetail=jobBuilder.build();



        // 2、创建触发器
        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        // 创建分组和名称
        triggerBuilder.withIdentity("calendarInterval_Trigger","calendarIntervalGroup");

        // 实例参数
        // 如果存在相同的数据，Trigger中的JobDataMap的值会覆盖JobDetail中的JobDataMap的值
        triggerBuilder.usingJobData("Tname","Tname:calendarIntervalTrigger");
        /**
         *
         * 2.1 CalendarIntervalTrigger 可以定义更多时间单位的调度需求，精确到秒。
         * 好处是不需要去计算时间间隔，比如 1 个小时等于多少毫秒。
         * 例如每年、每个月、每周、每天、每小时、每分钟、每秒。
         * 每年的月数和每个月的天数不是固定的，这种情况也适用。
         *
         */
        CalendarIntervalScheduleBuilder calendarIntervalScheduleBuilder = CalendarIntervalScheduleBuilder.calendarIntervalSchedule();
        // 执行次数，间隔1分钟执行一次
        calendarIntervalScheduleBuilder.withIntervalInMinutes(1);
        triggerBuilder.withSchedule(calendarIntervalScheduleBuilder);
        triggerBuilder.startAt(new Date(new Date().getTime()+6000));
        triggerBuilder.startNow();
        // 创建Trigger
        Trigger trigger = triggerBuilder.build();




        // 3、 创建Scheduler Scheduler 先启动后启动无所谓，只要有 Trigger 到达触发条件，就会执行任务
        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler scheduler = factory.getScheduler();
        // 把 JobDetail 和 Trigger 绑定，注册到容器中。
        scheduler.scheduleJob(jobDetail,trigger);
        //Scheduler 先启动后启动无所谓，只要有 Trigger 到达触发条件，就会执行任务
        scheduler.start();






    }

}
