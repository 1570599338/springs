package com.lquan.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * job执行任务
 */
public class MyJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************执行MyJob2-start*********************************");
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println( " " + sf.format(date) + " 任务1执行了，" + dataMap.getString("gupao"));
        System.out.println("********************************执行MyJob2-end*********************************");
        System.out.println();
        System.out.println();
        System.out.println();


    }
}
