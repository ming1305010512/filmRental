package com.learn.arithmetic.pointOffer.twelve_num_power;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 11:24
 * @Description:其他方式求解数值的整数次方
 */
public class RecursionWayNumPower {

    /**
     * 使用递归求解
     *
     * 如果n是奇数，x^n = (x^n/2)^2*x;如果n是偶数x^n = (x^n/2)^2
     * @param base
     * @param exponent
     * @return
     */
    public double entirePower(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        double result = entirePower(base,exponent/2);
        //奇数
        if ((exponent & 1) != 0){
            result = result * result * base;
        }else {
            result = result * result;
        }
        return result;
    }

    public double Power(double base, int exponent) {
        if (exponent < 0){
            base = 1/base;
            exponent = -exponent;
        }
        return entirePower(base,exponent);
    }

    public static void main(String[] args) {
        RecursionWayNumPower otherWayNumPower = new RecursionWayNumPower();
        System.out.println(otherWayNumPower.Power(2,3));
    }
}
