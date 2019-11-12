package com.learn.java.newFeatures.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/8
 * @Time:15:06
 * @Description lambda表达式测试类
 */
public class MainTest {
    public static void main(String[] args) {
        MathOperation mo1 = (a,b)->a+b;
        MathOperation mo2 = (int a,int b)->a+b;
        MathOperation mo3 = (a,b)->{
            System.out.println("我是lambda表达式");
            return a+b;
        };
        System.out.println(mo1.operation(1,2));
        System.out.println(mo2.operation(2,2));
        System.out.println(mo3.operation(2,3));
    }

    public void aa(){
        String salutation = "hello!";
        //定义函数，使用外部字符串
        MenthodInterface mi = message -> {
            System.out.println(salutation+message);
        };
        mi.doSomething("word");
        System.out.println(salutation);
    }

    /**
     * 下面是java中使用lambda表达式的举例
     */
    /**
     * 1、线程
     */
    public void javaExampleWithThread(){
        //旧方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aa");
            }
        }).start();
        //新方法
        new Thread(()-> System.out.println("aa")).start();
    }

    /**
     * 遍历list
     */
    public void javaExampleWithTraverse(){
        //旧方法
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        for (Integer n:list){
            System.out.println(n);
        }
        //新方法
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        list1.forEach(n-> System.out.println(n));
        HashMap map = new HashMap();
//        map.forEach();
    }
}
