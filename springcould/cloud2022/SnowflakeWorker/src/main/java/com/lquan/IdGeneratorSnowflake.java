package com.lquan;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-18 16:48
 **/
@Slf4j
@Component
public class IdGeneratorSnowflake {
    private long workerId;
    private long datacenterId;

    private Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);

    @PostConstruct
    public void  init(){
        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch (Exception e){
           log.error("当前机器的workerId获取失败",e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public  synchronized  long snowflakeId(){
        return snowflake.nextId();
    }

    public  synchronized long snowflakeId(long workerId, long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }


    public static void main(String[] args) {
        long l = new IdGeneratorSnowflake().snowflakeId();
        System.out.println(l);
    }
}
