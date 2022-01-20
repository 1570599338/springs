package com.lquan.quartz.javatime;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: springs
 * @description: 测试实例
 * @author: lquan
 * @create: 2022-01-20 13:37
 **/
public class TimerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new JavaTimerTask();
        timer.schedule(task, 5000L, 2000L);
    }
}
