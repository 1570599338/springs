package com.lquan.quartz.listener.trigger;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @program: springs
 * @description: Trigger的监听
 * @author: lquan
 * @create: 2022-01-19 17:06
 **/
public class MyTriggerListener implements TriggerListener {

    private String name;

    public MyTriggerListener(String name) {
        this.name = name;
    }




    /**
     * 返回监听器的名称
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Trigger 被触发， Job 上的 execute() 方法将要被执行时， Scheduler 就调用这个
     * 方法
     * @param trigger
     * @param jobExecutionContext
     */
    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method 11111 " + triggerName + " was fired");
    }

    /**
     * 在 Trigger 触 发 后 ， Job 将 要 被 执 行 时 由 Scheduler 调 用 这 个 方 法 。
     * TriggerListener 给了一个选择去否决 Job 的执行。 假如这个方法返回 true， 这
     * 个 Job 将不会为此次 Trigger 触发而得到执行
     * @param trigger
     * @param jobExecutionContext
     * @return
     */
    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method 222222 " + triggerName + " was not vetoed");
        return false;
    }

    /**
     * Trigger 错过触发时调用
     * @param trigger
     */
    @Override
    public void triggerMisfired(Trigger trigger) {

        String triggerName = trigger.getKey().getName();
        System.out.println("Method 333333 " + triggerName + " misfired");

    }

    /**
     * Trigger 被触发并且完成了 Job 的执行时， Scheduler 调用这个方法
     * @param trigger
     * @param jobExecutionContext
     * @param completedExecutionInstruction
     */
    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method 444444 " + triggerName + " is complete");
        System.out.println("------------");
    }
}
