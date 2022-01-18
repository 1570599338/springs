package com.lquan.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * job执行任务
 */
public class MyJob1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("*******************************************************************");

        System.out.println("jobExecutionContext = [" + jobExecutionContext + "]:MyJob1");
        JobDataMap jobDataMapJob = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap jobDataMapTrigger = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println(jobDataMapJob.get("fname")+"************"+jobDataMapJob.get("price")+"********************"+jobDataMapTrigger.get("triggerFname")+"****************"+jobDataMapTrigger.get("triggerPrice"));

        System.out.println("*******************************************************************");

    }
}
