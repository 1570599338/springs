package com.lquan.listener.run;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author lquan
 * @create 2022- 12-22 上午1:19
 * @description
 */
@Configuration
public class MyApplicationRunner implements ApplicationRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner......run.......");
    }
}
