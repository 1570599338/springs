package com.lquan.quartz.trigger.dailyTimeInterval;

import com.lquan.quartz.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @program: springs
 * @description: DailyTimeIntervalTrigger 每天的某个时间段内，以一定的时间间隔执行任务。 例如：每天早上 9 点到晚上 9 点，每隔半个小时执行一次，并且只在周一到周六执 行。
 * @author: lquan
 * @create: 2022-01-19 15:22
 **/
public class DailyTimeIntervalTriggerDemo {

    public static void main(String[] args) throws Exception {

        //1、创建JobDetail
        JobBuilder jobBuilder = JobBuilder.newJob(MyJob1.class);
        jobBuilder.withIdentity("jobDaliy","GropDaliy");
        jobBuilder.usingJobData("fname","jobDaliy");
        jobBuilder.usingJobData("price","price:GropDaliy");
        // 实例化JobDetail
        JobDetail jobDetail = jobBuilder.build();


        //2、创建trigger
        DailyTimeIntervalScheduleBuilder dailyTimeIntervalScheduleBuilder = DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule();

        // 开始时间
        dailyTimeIntervalScheduleBuilder.startingDailyAt(TimeOfDay.hourAndMinuteOfDay(15,40));
        // 结束时间每天15：30 00
        dailyTimeIntervalScheduleBuilder.endingDailyAt(TimeOfDay.hourMinuteAndSecondOfDay(15,42,0));
       // 间隔时间 3秒
        dailyTimeIntervalScheduleBuilder.withIntervalInSeconds(3);

        // 3、创建Trigger
        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        // 定义名称和分组
        triggerBuilder.withIdentity("Tname：DailyTimeInterval","TGroup:DailyTimeInterval");
        // 触发方式
        triggerBuilder.withSchedule(dailyTimeIntervalScheduleBuilder);
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
