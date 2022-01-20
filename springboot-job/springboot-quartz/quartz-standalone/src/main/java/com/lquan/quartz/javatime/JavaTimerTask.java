package com.lquan.quartz.javatime;

import java.util.TimerTask;

/**
 * @program: springs
 * @description: 测试jdk自带的任务调度
 * @author: lquan
 * @create: 2022-01-20 13:34
 **/
public class JavaTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("JavaTimerTask打印定时任务调度");

    }
}
