package com.learn.java.String;

import java.util.Arrays;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/4/1
 * @Time: 17:07
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        String aa = "";
        List<String> aas = Arrays.asList(aa.split(","));
        System.out.println("111");

        String str = "01";
        System.out.println(str.substring(1,2));
        System.out.println(str.substring(0,1));
    }
}
