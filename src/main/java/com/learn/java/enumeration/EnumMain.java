package com.learn.java.enumeration;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/10
 * @Time:20:49
 */
public class EnumMain {

    public static void main(String[] args) {
//        for (PositionEnum positionEnum:PositionEnum.values()){
//            System.out.println(positionEnum.toString());
//        }
        double x=3;
        double y =4;
        for (Operation operation:Operation.values()){
            System.out.printf("%f %s %f= %f%n",x ,operation,y,operation.apply(x,y));
        }
    }

}
