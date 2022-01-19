package com.lquan.quartz.listener.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-01-19 16:35
 **/
public class MyJobListenter implements JobListener {

    /**
     * 返回JobListener的名称
     * @return
     */
    @Override
    public String getName() {
       String name = this.getClass().getSimpleName();
        System.out.println( "Method 111111 :"+ "获取到监听器名称："+name);
        return name;
    }

    /**
     * Scheduler 在 JobDetail 将要被执行时调用这个方法
     * @param jobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        System.out.println("***********************jobToBeExecuted cheduler 在 JobDetail 将要被执行时调用这个方法*************************************");
        System.out.println("名称2222[" + jobExecutionContext.getJobDetail().getKey().getName() + "]");
        System.out.println("分组22222[" + jobExecutionContext.getJobDetail().getKey().getGroup()+ "]");
        System.out.println("********************************jobToBeExecuted END**********************************");

    }

    /**
     * Scheduler 在 JobDetail 即将被执行， 但又被 TriggerListener 否决了时调用这个方法
     * @param jobExecutionContext
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

        System.out.println("***********************jobExecutionVetoed Scheduler 在 JobDetail 即将被执行， 但又被 TriggerListener 否决了时调用这个方法*************************************");
        System.out.println("名称3333[" + jobExecutionContext.getJobDetail().getKey().getName() + "]");
        System.out.println("分组3333[" + jobExecutionContext.getJobDetail().getKey().getGroup()+ "]");
        System.out.println("********************************jobExecutionVetoed END**********************************");


    }

    /**
     * Scheduler 在 JobDetail 被执行之后调用这个方法
     * @param jobExecutionContext
     * @param e
     */
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("***********************jobWasExecuted Scheduler 在 JobDetail 被执行之后调用这个方法*************************************");
        System.out.println("名称44444[" + jobExecutionContext.getJobDetail().getKey().getName() + "]");
        System.out.println("分组44444[" + jobExecutionContext.getJobDetail().getKey().getGroup()+ "]");
        System.out.println("********************************jobWasExecuted END**********************************");

    }
}
