package com.learn.java.methodTest;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/4/23
 * @Time:11:35
 */
public class MenthodTest {

    public static void main(String[] args) {
        String a = null;
        aa(a);
    }

    public static void aa(String a){
        System.out.println("1111");
        System.out.println("222");
        if (a==null){
            return;
        }
        System.out.println("333");
        System.out.println("444");
    }
}
