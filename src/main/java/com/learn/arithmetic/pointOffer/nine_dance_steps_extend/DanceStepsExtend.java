package com.learn.arithmetic.pointOffer.nine_dance_steps_extend;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/22
 * @Time: 17:25
 * @Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 * 示例1
 * 输入：
 *
 * 3
 *
 * 返回值：
 *
 * 4
 */
public class DanceStepsExtend {

    public int jumpFloorII(int target) {
        int data[] = new int[target+1];
        data[0] = data[1] = 1;
        for (int i = 2;i <= target;i++){
            data[i] = data[i-1]<<1;
        }
        return data[target];
    }

    public static void main(String[] args) {
        DanceStepsExtend danceStepsExtend = new DanceStepsExtend();
        System.out.println(danceStepsExtend.jumpFloorII(4));
    }
}
