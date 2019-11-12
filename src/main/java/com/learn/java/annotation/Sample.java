package com.learn.java.annotation;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/11
 * @Time:17:19
 */
public class Sample {

    @Test
    public static void m1(){}
    @Test
    public static void m3(){
        throw new RuntimeException("Boom");
    }

}
