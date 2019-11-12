package com.learn.spring.ThreadPoolAndTask;

import com.learn.Utils.BeanUtils.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/7
 * @Time:17:47
 * @Description: 使用线程池手动执行任务
 */
public class ManualExecuteTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/learn/threadPoolAndTask.xml");
        TaskExecutor taskExecutor = (TaskExecutor) ctx.getBean("taskExecutor");
        // MyTask myTask = (MyTask) ctx.getBean("myTask");

        Lock lock = new ReentrantLock();
        // for (int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                MyTask myTask = new MyTask();
                taskExecutor.execute(myTask);
            }
        System.out.println("了开始看的计算扣减");*/
        // }




        //测试二
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/learn/threadPoolAndTask.xml");
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) ctx.getBean("taskExecutor");
        // MyTask myTask = (MyTask) ctx.getBean("myTask");

        Lock lock = new ReentrantLock();
        MyTask myTask = new MyTask();
        // FutureTask<Double> runnableTask = new FutureTask<>(myTask,null);
        // taskExecutor.submit(runnableTask);
        taskExecutor.execute(myTask);
        // Double a = runnableTask.get();
        System.out.println("了开始看的计算扣减");
        System.out.println("怎么回事");
    }
}
