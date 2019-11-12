package com.learn.spring.ThreadPoolAndTask;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/7
 * @Time:18:56
 */
public class MyTaskScheduler implements TaskScheduler {

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/learn/threadPoolAndTask.xml");
        TaskExecutor taskExecutor = (TaskExecutor) ctx.getBean("taskExecutor");
        taskExecutor.execute(task);

        return null;
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Date startTime) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Date startTime, long period) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, Date startTime, long delay) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, long delay) {
        return null;
    }
}
