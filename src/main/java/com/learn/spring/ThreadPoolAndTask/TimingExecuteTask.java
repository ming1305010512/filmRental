package com.learn.spring.ThreadPoolAndTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/7
 * @Time:19:04
 * @Description: 定时执行任务
 */
public class TimingExecuteTask {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/learn/threadPoolAndTask.xml");
        MyTask myTask = (MyTask) ctx.getBean("myTask");
        ThreadPoolTaskScheduler threadPoolTaskScheduler = (ThreadPoolTaskScheduler) ctx.getBean("threadPoolTaskScheduler");
        Trigger trigger = new CronTrigger("0/5 * * * * ?");
        threadPoolTaskScheduler.schedule(myTask,trigger);
    }
}
