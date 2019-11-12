package com.learn.java.decimal;

import java.math.BigDecimal;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/4/11
 * @Time:15:44
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        System.out.println(new BigDecimal(0.1).toString()); // 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal("0.1").toString()); // 0.1
        System.out.println(new BigDecimal(Double.toString(0.1000000000000000055511151231257827021181583404541015625)).toString());// 0.1
        System.out.println(new BigDecimal(Double.toString(0.1)).toString()); // 0.1

        System.out.println(new BigDecimal("2343.3").divide(new BigDecimal("1.13"),2,BigDecimal.ROUND_HALF_UP));
    }
}
