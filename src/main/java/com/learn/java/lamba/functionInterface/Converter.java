package com.learn.java.lamba.functionInterface;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/9/4
 * @Time:17:20
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
