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
 */
@Slf4j
@DisallowConcurrentExecution
public class TestTask1 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(Thread.currentThread().getName() + " " +sdf.format(date) + " Task1： ----咕泡学院，只为更好的你----");
        log.info(Thread.currentThread().getName() + " " +sdf.format(date) + " Task1.1： ----咕泡学院，只为更好的你----");
    }
}
