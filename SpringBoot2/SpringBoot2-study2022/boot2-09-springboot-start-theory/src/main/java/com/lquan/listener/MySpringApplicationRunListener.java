package com.lquan.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @author lquan
 * @create 2022- 12-22 上午1:08
 * @description
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private  SpringApplication springApplication;

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
    this.springApplication=application;
    }

    /**
     * Called immediately when the run method has first started. Can be used for very
     * early initialization.
     *
     * @param bootstrapContext the bootstrap context
     */
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MySpringApplicationRunListener.....starting...");

    }

    /**
     * Called once the environment has been prepared, but before the
     * {@link ApplicationContext} has been created.
     *
     * @param bootstrapContext the bootstrap context
     * @param environment      the environment
     */
    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener....environmentPrepared....");
    }

    /**
     * Called once the {@link ApplicationContext} has been created and prepared, but
     * before sources have been loaded.
     *
     * @param context the application context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener....contextPrepared....");
    }

    /**
     * Called once the application context has been loaded but before it has been
     * refreshed.
     *
     * @param context the application context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener....contextLoaded....");
    }

    /**
     * The context has been refreshed and the application has started but
     * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
     * ApplicationRunners} have not been called.
     *
     * @param context   the application context.
     * @param timeTaken the time taken to start the application or {@code null} if unknown
     * @since 2.6.0
     */
    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("MySpringApplicationRunListener.....started...");
    }



    /**
     * Called immediately before the run method finishes, when the application context has
     * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
     * {@link ApplicationRunner ApplicationRunners} have been called.
     *
     * @param context   the application context.
     * @param timeTaken the time taken for the application to be ready or {@code null} if
     *                  unknown
     * @since 2.6.0
     */
    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("MySpringApplicationRunListener....ready....");
    }


    /**
     * Called when a failure occurs when running the application.
     *
     * @param context   the application context or {@code null} if a failure occurred before
     *                  the context was created
     * @param exception the failure
     * @since 2.0.0
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringApplicationRunListener.....failed...");
    }
}
