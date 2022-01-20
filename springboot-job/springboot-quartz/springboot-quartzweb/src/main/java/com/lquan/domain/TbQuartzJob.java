package com.lquan.domain;

import lombok.ToString;
import java.io.Serializable;

/**
 * (TbQuartzJob)实体类
 *
 * @author lquan
 * @since 2022-01-20 16:14:05
 */
@ToString
public class TbQuartzJob implements Serializable {
    private static final long serialVersionUID = -58972613210035003L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务组名
     */
    private String jobGroup;
    /**
     * 时间表达式
     */
    private String jobCron;
    /**
     * 类路径,全类型
     */
    private String jobClassPath;
    /**
     * 传递map参数
     */
    private String jobDataMap;
    /**
     * 状态:1启用 0停用
     */
    private Integer jobStatus;
    /**
     * 任务功能描述
     */
    private String jobDescribe;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getJobClassPath() {
        return jobClassPath;
    }

    public void setJobClassPath(String jobClassPath) {
        this.jobClassPath = jobClassPath;
    }

    public String getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(String jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
    }

}

