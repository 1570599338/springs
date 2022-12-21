package com.lquan.listener.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author lquan
 * @create 2022- 12-22 上午1:21
 * @description
 *              应用启动做一个一次性事情
 */
@Configuration
public class MyCommandLineRunner implements CommandLineRunner {

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner......run.......");
    }
}
