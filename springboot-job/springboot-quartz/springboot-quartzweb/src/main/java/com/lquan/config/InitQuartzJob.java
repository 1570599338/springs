package com.lquan.config;

import com.alibaba.fastjson.JSON;
import com.lquan.dao.TbQuartzJobMapper;
import com.lquan.domain.TbQuartzJob;
import com.lquan.service.impl.QuartzSchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springs
 * @description: 1、Quartz的job在项目重启时，job都失效了，把每次启动的job都存放在数据库，
 *                 然后项目启动后从数据库读取数据库的job，然后添加job。
 *
 *               2、commandLineRunner的作用：在平常开发中可能需要实现在项目启动后执行的功能，
 *                  Springboot提供了一种简单的实现方案，即实现CommandLineRunner接口，实现功能的代码在接口的run方法里。
 *
 *              3、order：如果有多个类实现CommandLineRunner接口，如何保证顺序
 *                 SpringBoot在项目启动后会遍历所有实现CommandLineRunner的实体类并执行run方法，如果需要按照一定的顺序去执行，
 *                 那么就需要在实体类上使用一个@Order注解（或者实现Order接口）来表明顺序，
 *                 @Order 注解的执行优先级是按value值从小到大顺序，即：值越小优先级越高。
 *
 * @author: lquan
 * @create: 2022-01-21 10:03
 **/
@Component
@Order(value = 1)
@Slf4j
public class InitQuartzJob implements CommandLineRunner {


    @Resource
    private TbQuartzJobMapper mapper;

    @Autowired
   private QuartzSchedulerService quartzSchedulerService;


    /**
     *  项目启动后执行的功能
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        // 查询状态处于运行状态的数据
        TbQuartzJob tbQuartzJob = new TbQuartzJob();
        tbQuartzJob.setJobStatus(1);
        List<TbQuartzJob> jobList =mapper.queryQuartzJobList(tbQuartzJob);
        if( null == jobList || jobList.size() ==0){
            log.info("系统启动，没有需要执行的任务... ...");
        }else{
            for (TbQuartzJob job:jobList){
                if(quartzSchedulerService.notExists(job.getJobName(),job.getJobGroup())){//在第一次进行加载数据是执行，并且防止在集群情况下重复加载
                    quartzSchedulerService.addBeanJob(job);
                }

            }

        }

    }
}
