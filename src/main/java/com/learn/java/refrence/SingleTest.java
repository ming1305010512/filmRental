package com.learn.java.refrence;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/15
 * @Time:21:06
 */
public class SingleTest {

    @Test
    public void test1() throws InterruptedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.learn.java.refrence.SingleTest");
        Class class1 = clazz.getClass();
        SingleTest cc = (SingleTest) clazz.newInstance();
        System.out.println(cc);
//        Method method = class1.getDeclaredMethod("getInstance");
//        System.out.println(method.invoke((SingleTest)class1.newInstance()));
    }


}
