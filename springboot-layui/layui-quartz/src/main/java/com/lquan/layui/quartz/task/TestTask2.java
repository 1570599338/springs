package com.lquan.layui.quartz.task;

import com.lquan.layui.quartz.inter.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:
 * @Date: 2018/9/11 17:15
 * @Description: 任务2
 */
public class TestTask2 implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(Thread.currentThread().getName() + " " +sdf.format(date) + " Task2： ----做技术人的指路明灯，职场生涯的精神导师----");
    }
}
