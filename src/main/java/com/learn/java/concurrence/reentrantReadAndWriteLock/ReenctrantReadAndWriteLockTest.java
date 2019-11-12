package com.learn.java.concurrence.reentrantReadAndWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/10
 * @Time:15:55
 */
public class ReenctrantReadAndWriteLockTest {

    //模拟共享资源--Number
    private int number = 0;
    // 实际实现类--ReentrantReadWriteLock，默认非公平模式
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读
    public void get(){
        //使用读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println();
            System.out.println("我是读线程："+Thread.currentThread().getName());
            System.out.println(number);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
    //写
    public void set(int number){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("我是写线程："+Thread.currentThread().getName());
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
