package com.lquan.quartz.task;


import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:
 * @Date:
 * @Description:
 * @DisallowConcurrentExecution注解可以控制我们的相同类的定时任务同时只有一个执行。通常的场景是如果定时任务实际执行时间大于设定的定时任务执行间隔时间，就会导致同时多个任务并行。
 *
 */
@Slf4j
@DisallowConcurrentExecution
public class TestTask1 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(Thread.currentThread().getName() + " " +sdf.format(date) + " Task1.1： ----Hello world----");
    }
}
