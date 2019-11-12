package com.learn.java.Reflect.Test;

import com.learn.java.Reflect.dto.User;

import java.lang.reflect.Field;

public class Main {

    /**
     * 利用反射获取指定对象里面的指定属性
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName){
        Field field = null;
        for (Class<?> clazz = obj.getClass();clazz != Object.class;clazz = clazz.getSuperclass()){
            try {
                field = clazz.getDeclaredField((fieldName));
                break;
            } catch (NoSuchFieldException e) {
                // 这里不用做处理，子类没有该字段了能对应的父类有，都没有就返回null
            }
        }
        return field;
    }


    public static void main(String[] args) {
//        Main mainTest = new Main();
        User user = new User();
        Field userField = Main.getField(user,"name");
        System.out.println(userField);
//        HashSet
    }
}
