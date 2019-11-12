package com.learn.java.lamba.functionInterface;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/9/4
 * @Time:17:20
 */
public class TestMain {

    public static void main(String[] args) {
        Converter<String,Integer> converter = (from -> Integer.valueOf(from));
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());

        //访问局部变量
        int num = 1;
        Converter<Integer,String> stringConverter = (from -> String.valueOf(from+num));
        String a = stringConverter.convert(2);
        // num = 4; //更改会报错
        System.out.println(a);
    }
}
