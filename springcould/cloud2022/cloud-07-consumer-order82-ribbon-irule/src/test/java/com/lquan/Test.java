package com.lquan;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lquan
 * @create 2022- 12-26 上午2:37
 * @description
 */
public class Test {

    public static void main(String[] args) {
         AtomicInteger atomicInteger = new AtomicInteger ( 0 );
         int current=0;
         int next=0;
        boolean b = atomicInteger.compareAndSet(current, next);
        System.out.println(b);

    }
}
