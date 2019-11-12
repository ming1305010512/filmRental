package com.learn.java.concurrence.volatitle;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/8
 * @Time:16:46
 * @Description: 关键字volatitle原子性测试
 */
public class VolatitleTest {

    public volatile int inc = 0;

    Lock lock = new ReentrantLock();
    public void increase() {
        // lock.lock();
        try {
            inc++;

        } finally {
            // lock.unlock();
        }
        System.out.println(inc);
    }

    public static void main(String[] args) {
        final VolatitleTest test = new VolatitleTest();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                test.increase();
            }).start();
        }

        // //保证前面的线程都执行完
        // while(Thread.activeCount()>1) {
        //     Thread.yield();
        // }
        System.out.println("哈哈哈");
        // System.out.println(test.inc);
    }
}
