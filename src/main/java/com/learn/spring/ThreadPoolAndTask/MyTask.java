package com.learn.spring.ThreadPoolAndTask;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/7
 * @Time:17:38
 * @Description: 自己定义的任务
 */
@Service
public class MyTask implements Runnable{

    public static volatile int inc = 0;

    // Lock lock = new ReentrantLock();
    @Override
    public void run() {
        // lock.lock();

        try {
            inc++;
            System.out.println("我是一个任务，被"+Thread.currentThread().getName()+"执行着");
            System.out.println("inc的值为："+inc);
        } finally {
            // lock.unlock();
        }
    }
}
