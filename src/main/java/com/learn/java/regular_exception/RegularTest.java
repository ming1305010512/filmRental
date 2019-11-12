package com.learn.java.regular_exception;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/30
 * @Time:14:04
 */
public class RegularTest {

    public static void main(String[] args) {

        //待判断的字符串
        String str="hap:cache:quartzServiceImpl:hscs_job_prefix_job:DEFAULT:测试";
        //判断字符串中是否含有ll
        String reg="hap:cache:quartzServiceImpl:hscs_job_prefix_job:" + "*:"+"*";
        System.out.println(str.matches(reg));
    }
}
