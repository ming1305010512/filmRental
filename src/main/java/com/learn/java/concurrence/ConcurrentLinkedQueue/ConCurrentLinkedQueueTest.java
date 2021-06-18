package com.learn.java.concurrence.ConcurrentLinkedQueue;


import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/4/2
 * @Time: 13:38
 * @Description:
 */
public class ConCurrentLinkedQueueTest {

    @Test
    public void addTest(){
        ConcurrentLinkedQueue<String> linkedQueue = new ConcurrentLinkedQueue<>();
        linkedQueue.add("1");
        linkedQueue.add("2");
        System.out.println("查看add方法逻辑");
    }
}
