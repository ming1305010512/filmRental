package com.learn.jvm.returnValue;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/11/6
 * @Time:15:07
 * @Description: 方法返回情况
 */
public class ReturnTest {
    public static void main(String[] args) {
       int a = new ReturnTest().inc();
        System.out.println(a);
    }

    public int inc() {
        int x;
        try {
            x=1;
            return x;
        } catch (Exception e) {
            x=2;
            return x;
        } finally {
            x=3;
            return x;
        }
    }
}
