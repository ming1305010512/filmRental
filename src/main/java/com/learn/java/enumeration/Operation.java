package com.learn.java.enumeration;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/11
 * @Time:12:16
 * @Description 四则运算枚举
 */
public enum  Operation {
    PLUS("+") {@Override double apply(double x,double y){return x+y;}},
    MINUS("-"){@Override double apply(double x,double y){return x-y;}},
    TIMES("*"){@Override double apply(double x,double y){return x*y;}},
    DIVIDE("/"){@Override double apply(double x,double y){return x/y;}};

    private final String symbol;
    Operation(String symbol){this.symbol=symbol;};
    abstract double apply(double x,double y);
    @Override public String toString(){return symbol;}
}
