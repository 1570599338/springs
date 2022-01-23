package com.lquan.quartz.task;


import com.lquan.dao.TbQuartzJobMapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:
 * @Date: 2018/9/11 17:15
 * @DisallowConcurrentExecution注解可以控制我们的相同类的定时任务同时只有一个执行。通常的场景是如果定时任务实际执行时间大于设定的定时任务执行间隔时间，就会导致同时多个任务并行。
 *
 */
@Slf4j
@DisallowConcurrentExecution
public class TestTask2 implements Job {

    @Resource
    private TbQuartzJobMapper mapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(Thread.currentThread().getName() + " " +sdf.format(date) + " Task2： mapper"+mapper+" ----Hello world----");
    }
}
