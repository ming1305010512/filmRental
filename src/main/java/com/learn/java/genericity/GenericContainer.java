package com.learn.java.genericity;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/8
 * @Time:12:06
 * @Description 泛型测试
 */
public class GenericContainer<T> {
    private T obj;

    public GenericContainer(){

    }

    public GenericContainer(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
