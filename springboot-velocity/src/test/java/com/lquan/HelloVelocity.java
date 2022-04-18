package com.lquan;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: springs
 * @description: 测试velocity
 * @author: lquan
 * @create: 2022-04-18 16:39
 **/
public class HelloVelocity {

    @Test
    public  void test() {
        // 1、初始化并获取Velocity引擎
        VelocityEngine  ve = new VelocityEngine();
        ve.init();

        // 获取velocity的模板
        Template template = ve.getTemplate("hellovelocity.vm");
        // 获取velocity的上下文context
        VelocityContext context = new VelocityContext();
        // 把数据填入上下文
        context.put("name","lquan");
        context.put("date",(new Date()).toString());
        // 为后面的展示，提前输入list数值
        List temp = new ArrayList();
        temp.add("1");
        temp.add("2");
        context.put("list", temp);

        //输出流
        StringWriter writer = new StringWriter();
        //转换输出
        template.merge(context, writer);
        System.out.println(writer.toString());

    }
}
