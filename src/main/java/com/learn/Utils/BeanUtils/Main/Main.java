package com.learn.Utils.BeanUtils.Main;

import com.learn.Utils.BeanUtils.dto.User;

public class Main {

    <R,A> A sum(Object a){
        return (A)a;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int a = main.sum(2);
        String str=main.sum("1");
        System.out.println("str:"+str);

        double aDouble=main.sum(1.32d);
        System.out.println("aDouble:"+aDouble);

        float aFloat=main.sum(1.2f);
        System.out.println("aFloat:"+aFloat);
        System.out.println(a);
//        User user = new User();
//        user.setAge("10");
//        user.setId("11");
//        user.setUserName("彩儿");
//        user.setPassword("123456");
//        System.out.println(user.toString());
    }
}
