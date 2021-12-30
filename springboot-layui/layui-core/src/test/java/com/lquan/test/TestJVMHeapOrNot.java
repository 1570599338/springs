package com.lquan.test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class TestJVMHeapOrNot {
    public static void main(String[] args) throws  Exception{
        MemoryMXBean mxb = ManagementFactory.getMemoryMXBean();
        for (int i=0;i<10;i++) {
            //Heap
            System.out.println("Max:" + mxb.getHeapMemoryUsage().getMax() / 1024 / 1024 + "MB");    //Max:1776MB
            System.out.println("Init:" + mxb.getHeapMemoryUsage().getInit() / 1024 / 1024 + "MB");  //Init:126MB
            System.out.println("Committed:" + mxb.getHeapMemoryUsage().getCommitted() / 1024 / 1024 + "MB");   //Committed:121MB
            System.out.println("Used:" + mxb.getHeapMemoryUsage().getUsed() / 1024 / 1024 + "MB");  //Used:7MB
            System.out.println(mxb.getHeapMemoryUsage().toString());    //init = 132120576(129024K) used = 8076528(7887K) committed = 126877696(123904K) max = 1862270976(1818624K)

            //Non heap
            System.out.println("Max:" + mxb.getNonHeapMemoryUsage().getMax() / 1024 / 1024 + "MB");    //Max:0MB
            System.out.println("Init:" + mxb.getNonHeapMemoryUsage().getInit() / 1024 / 1024 + "MB");  //Init:2MB
            System.out.println("Committed:" + mxb.getNonHeapMemoryUsage().getCommitted() / 1024 / 1024 + "MB");   //Committed:8MB
            System.out.println("Used:" + mxb.getNonHeapMemoryUsage().getUsed() / 1024 / 1024 + "MB");  //Used:7MB
            System.out.println(mxb.getNonHeapMemoryUsage().toString());    //init = 2555904(2496K) used = 7802056(7619K) committed = 9109504(8896K) max = -1(-1K)
            System.out.println("---------------------------------------------");
            Thread.sleep(1000);
        }
        }
}
