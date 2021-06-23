package com.learn.arithmetic.pointOffer.eleven_one_num_in_binary;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 9:58
 * @Description:
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例1
 * 输入：
 *
 * 10
 *
 * 返回值：
 *
 * 2
 */
public class OneNumInBinary {

    /**
     * 把整数当成二进制进行运行，使用1从右到左位与算出1的个数
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int bNum = 0;
        int flag = 1;
        while (flag!=0){
            if ((flag & n)!=0){
                bNum++;
            }
            flag <<= 1;
        }
        return bNum;
    }

    /**
     * 减1在与他位与可以消除一个1
     * val :1101000, val-1: 1100111 那么val & （val-1） : 1100000
     * @param n
     * @return
     */
    public int NumberOf2(int n){
        int bNum = 0;
        while (n!=0){
            bNum++;
            n = n & (n-1);
        }
        return bNum;
    }

    public static void main(String[] args) {
        OneNumInBinary oneNumInBinary = new OneNumInBinary();
        System.out.println(oneNumInBinary.NumberOf1(-9));
        System.out.println(1<<2);
    }
}
