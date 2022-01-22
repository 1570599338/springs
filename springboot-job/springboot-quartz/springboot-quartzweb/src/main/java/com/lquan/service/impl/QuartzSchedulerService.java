package com.lquan.service.impl;

import com.alibaba.fastjson.JSON;
import com.lquan.domain.TbQuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springs
 * @description: 任务调度处理
 * @author: lquan
 * @create: 2022-01-21 10:39
 **/
@Slf4j
@Service
public class QuartzSchedulerService {

    @Autowired
    private Scheduler scheduler;


    /**
     * 添加一个定时任务
     *
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务
     * @param cron             时间设置，参考quartz说明文档
     */
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, String jobClass, String cron, Map<String, Object> params) {
        try {

            if(checkExists(jobName, jobGroupName, triggerName, triggerGroupName)) {
                //先移除后添加
                jobdelete(jobName, jobGroupName, triggerName, triggerGroupName);
            }

            //1、 创建JobDetail
            Class<? extends Job> clz = (Class<? extends Job>) Class.forName(jobClass).newInstance().getClass();
            JobDetail jobDetail = JobBuilder.newJob(clz).withIdentity(jobName,jobGroupName).build();
            // 任务参数
            if(params!=null&&!params.isEmpty()){
                jobDetail.getJobDataMap().putAll(params);
            }

            //2、创建Trigger
            Trigger trigger =TriggerBuilder.newTrigger()//触发器
                    .withIdentity(triggerName,triggerGroupName)// 触发器命名、分组
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))// 触发器设置时间
                    .startNow()// 获取当前时间，把当前时间设置为执行时间
                    .build();

            //调度容器设置JobDetail和Trigger
            this.scheduler.scheduleJob(jobDetail,trigger);

            if(!this.scheduler.isShutdown()){
                this.scheduler.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     *   修改一个任务的触发时间
     * @param triggerName
     * @param triggerGroupName
     * @param cron
     */
    public void modifyJobTime(String triggerName, String triggerGroupName, String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroupName);
            CronTrigger cronTrigger = (CronTrigger)this.scheduler.getTrigger(triggerKey);
            if(cronTrigger==null){
                return;
            }
           String oldCron = cronTrigger.getCronExpression();
            if(!oldCron.equalsIgnoreCase(cron)){
                // 按新的cronExpression表达式重新构建trigger
                cronTrigger = cronTrigger.getTriggerBuilder()
                        .withIdentity(triggerKey)// 定义分组和名称
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron))// 设置触发器时间
                        .startNow()// 获取当前时间，把当前时间设置为执行时间
                        .build();
                // 修改一个任务的触发时间  按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, cronTrigger);
            }


        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除某个任务
     *
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void jobdelete(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.deleteJob(jobKey);
    }

    /**
     *  移除一个任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public void jobdelete(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroupName);
            // 停止触发器
            this.scheduler.pauseTrigger(triggerKey);
            // 删除触发器
            this.scheduler.unscheduleJob(triggerKey);
            // 删除job
            this.scheduler.deleteJob(JobKey.jobKey(jobName,jobGroupName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 停用一个定时任务
     * @param jobName 任务名称
     * @param jobGroupName 组别
     * @throws Exception
     */
    public  void jobPause(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
            if(this.scheduler.getJobDetail(jobKey)==null)
                return;
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启用一个定时任务
     * @param jobName 任务名称
     * @param jobGroupName 组别
     * @throws Exception
     */
    public  void jobresume(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = JobKey.jobKey(jobName,jobGroupName);
            JobDetail jobDetail = this.scheduler.getJobDetail(jobKey);
            if(jobDetail==null)
                return;
            this.scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 检查Job是否存在
     *
     * @param jobName
     * @param jobGroupName
     * @return
     * @throws Exception
     */
    public  Boolean isResume(String jobName, String jobGroupName) throws Exception {

        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
        Boolean state = scheduler.checkExists(triggerKey);

        return state;
    }

    /**
     * 暂停所有任务
     * @throws Exception
     */
    public  void pauseAlljob() throws Exception {
        scheduler.pauseAll();
    }

    /**
     * 唤醒所有任务
     * @throws Exception
     */
    public  void resumeAlljob() throws Exception {

        scheduler.resumeAll();
    }







    /**
     *  获取任务是否存在
     *                  STATE_BLOCKED 4 阻塞
     *                  STATE_COMPLETE 2 完成
     *                  STATE_ERROR 3 错误
     *                  STATE_NONE -1 不存在
     *                  STATE_NORMAL 0 正常
     *                  STATE_PAUSED 1 暂停
     * @param triggerName
     * @param triggerGroupName
     * @return
     */
    public Boolean notExists(String triggerName, String triggerGroupName) {
        try {
            Trigger.TriggerState staus =this.scheduler.getTriggerState(TriggerKey.triggerKey(triggerName,triggerGroupName));

            return staus==Trigger.TriggerState.NONE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 检查是否存在
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @return
     */
    public boolean checkExists(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            JobKey jobKey = new JobKey(jobName, jobGroupName);
            boolean triggerCheck = scheduler.checkExists(triggerKey);
            boolean jobCheck = scheduler.checkExists(jobKey);
            return triggerCheck || jobCheck;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    /**
     *  获取任务是否存在
     *                  STATE_BLOCKED 4 阻塞
     *                  STATE_COMPLETE 2 完成
     *                  STATE_ERROR 3 错误
     *                  STATE_NONE -1 不存在
     *                  STATE_NORMAL 0 正常
     *                  STATE_PAUSED 1 暂停
     * @param triggerName
     * @param triggerGroupName
     * @return
     */
    public  Trigger.TriggerState getTiggerStatus(String triggerName, String triggerGroupName) {
        Trigger.TriggerState staus=Trigger.TriggerState.NONE;
        try {
            staus= this.scheduler.getTriggerState(TriggerKey.triggerKey(triggerName,triggerGroupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return staus;
    }














    /**
     *  添加一个定时任务
     * @param jobName
     * @param jobGroupName
     * @param jobClass
     * @param cron
     */
    public void addJob(String jobName, String jobGroupName, String jobClass, String cron) {
        addJob( jobName,  jobGroupName,  jobName,  jobGroupName,  jobClass,  cron, null);
    }


    /**
     *  添加一个定时任务
     * @param jobName
     * @param jobGroupName
     * @param jobClass
     * @param cron
     * @param params
     */
    public void addJob(String jobName, String jobGroupName, String jobClass, String cron, Map<String, Object> params) {
        addJob( jobName,  jobGroupName,  jobName,  jobGroupName,  jobClass,  cron, params);
    }

    /**
     * 添加一个定时任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param jobClass
     * @param cron
     * @param params
     */
    public void addJob(String jobName, String jobGroupName, String triggerName, String jobClass, String cron, Map<String, Object> params) {
        addJob( jobName,  jobGroupName,  triggerName,  jobGroupName,  jobClass,  cron, params);
    }


    /**
     * 添加任务
     * @param job
     */
    public void addBeanJob(TbQuartzJob job) {
        System.out.println("args = [" + job + "]");
        Map map = new HashMap();
        if(StringUtils.isNotEmpty(job.getJobDataMap()))
            map = JSON.parseObject(job.getJobDataMap(), HashMap.class);
        this.addJob(job.getJobName(),job.getJobGroup(),job.getJobClassPath(),job.getJobCron(),map);
    }

}
