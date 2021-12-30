package com.lquan.test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

import static com.lquan.layui.utils.UnitCovert.*;

public class MyTest {

    public static void main(String[] args) throws Exception{
       // /堆内存使用情况
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        //非堆内存使用情况
        MemoryUsage nonHeapMemoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        Runtime r = Runtime.getRuntime();

        for (int i=0;i<10;i++) {
            //JVM总内存数
            System.out.println("JVM总内存数" + kbToMBString(r.totalMemory()));
            //JVM剩余内存
            System.out.println("JVM剩余内存" + kbToMBString(r.freeMemory()));
            //JVM已使用内存
            System.out.println("JVM已使用内存" + kbToMBString(r.totalMemory() - r.freeMemory()));
            //jvm内存使用率
            System.out.println("jvm内存使用率" + retain2(((r.totalMemory() - r.freeMemory()) / (r.totalMemory() * 1.0)) * 100) + "%");
            //封装数据（堆内存及非堆内存）
            //堆内存初始大小
            System.out.println("堆内存初始大小" + kbToMBString(heapMemoryUsage.getInit()));
            //非堆内存初始大小
            System.out.println("非堆内存初始大小" + kbToMBString(nonHeapMemoryUsage.getInit()));
            //堆内存最大大小
            System.out.println("堆内存最大大小" + kbToGBString(heapMemoryUsage.getMax()));
            //非堆内存最大大小
            System.out.println("非堆内存最大大小" + kbToGBString(nonHeapMemoryUsage.getMax()));
            //堆内存已使用大小
            System.out.println("堆内存已使用大小" + kbToMBString(heapMemoryUsage.getUsed()));
            //非堆内存已使用大小
            System.out.println("非堆内存已使用大小" + kbToMBString(nonHeapMemoryUsage.getUsed()));
            //堆内存可使用大小
            System.out.println("堆内存可使用大小" + kbToGBString(heapMemoryUsage.getCommitted()));
            //非堆内存可使用大小
            System.out.println("非堆内存可使用大小" + kbToGBString(nonHeapMemoryUsage.getCommitted()));
            Thread.sleep(5000);
            System.out.println("---------------------------------------------");
        }

    }
}
