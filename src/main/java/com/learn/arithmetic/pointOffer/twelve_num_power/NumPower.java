package com.learn.arithmetic.pointOffer.twelve_num_power;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 10:54
 * @Description:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
 *
 * 示例1
 * 输入：
 *
 * 2.00000,3
 *
 * 返回值：
 *
 * 8.00000
 *
 * 示例2
 * 输入：
 *
 * 2.10000,3
 *
 * 返回值：
 *
 * 9.26100
 *
 * 示例3
 * 输入：
 *
 * 2.00000,-2
 *
 * 返回值：
 *
 * 0.25000
 *
 * 说明：
 *
 * 2的-2次方等于1/4=0.25
 */
public class NumPower {

    /**
     * 暴力求解
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = base;
        if (exponent>0){
            for (int i=2;i<=exponent;i++){
                result *= base;
            }
        }else if (exponent<0){
            int powNum = -exponent;
            for (int i=2;i<=powNum;i++){
                result *=base;
            }
            result = 1/result;
        }else if (exponent ==0){
            result = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        NumPower numPower = new NumPower();
        System.out.println(numPower.Power(2.00000,-2));
    }
}
