package com.learn.arithmetic.pointOffer.ten_matrix_cover;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/22
 * @Time: 20:00
 * @Description:
 *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，从同一个方向看总共有多少种不同的方法？
 *
 * 比如n=3时，2*3的矩形块有3种不同的覆盖方法(从同一个方向看)：
 *
 * 输入描述：
 * 2*1的小矩形的总个数n
 * 返回值描述：
 * 覆盖一个2*n的大矩形总共有多少种不同的方法(从同一个方向看)
 * 示例1
 * 输入：
 *
 * 0
 *
 * 返回值：
 *
 * 0
 *
 * 示例2
 * 输入：
 *
 * 1
 *
 * 返回值：
 *
 * 1
 *
 * 示例3
 * 输入：
 *
 * 4
 *
 * 返回值：
 *
 * 5
 */
public class MatrixCover {

    public int rectCover(int target) {
        if (target == 1 || target == 0 || target == 2){
            return target;
        }
        int a = 1,b = 2,c = 1;
        for (int i=2;i<target;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        MatrixCover matrixCover = new MatrixCover();
        System.out.println(matrixCover.rectCover(4));
    }
}
