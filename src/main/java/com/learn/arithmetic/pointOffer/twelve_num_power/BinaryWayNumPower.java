package com.learn.arithmetic.pointOffer.twelve_num_power;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 13:41
 * @Description:
 */
public class BinaryWayNumPower {

    /**
     * 通过二进制运算来求解
     * 6的二进制为110,6 = 0*2^0+1*2^1+1*2^2
     * x^6 = x^(0*2^0+1*2^1+1*2^2)
     *     = x^(0*2^0)*x^(1*2^1)*x^(1*2^2)
     *     =(x^0)^2*(x^1)^2*(x^2)^2
     *
     *遇到二进制位数为1的就进行答案的运算
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        if (exponent<0){
            base = 1/base;
            exponent = -exponent;
        }
        //x表示x^0,x^1,x^2......
        double x = base;
        double result = 1;
        while (exponent != 0){
            if ((exponent&1)!=0) {
                result *= x;
            }
            x *= x;
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryWayNumPower binaryWayNumPower = new BinaryWayNumPower();
        System.out.println(binaryWayNumPower.power(2,3));
    }
}
