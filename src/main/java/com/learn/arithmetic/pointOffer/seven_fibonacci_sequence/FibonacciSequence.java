package com.learn.arithmetic.pointOffer.seven_fibonacci_sequence;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/22
 * @Time: 15:17
 * @Description:
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 *
 * n≤39
 * 示例1
 * 输入：
 *
 * 4
 *
 * 返回值：
 *
 * 3
 */
public class FibonacciSequence {

    /**
     * 使用递归
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**
     * 使用动态规划
     * @param n
     * @return
     */
    public int Fibonacci2(int n){
        int data [] = new int[n+1];
        data[1] = 1;
        for (int i=2;i<=n;i++){
            data[i] = data[i-1]+data[i-2];
        }
        return data[n];
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.Fibonacci2(4));
    }
}
