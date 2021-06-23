package com.learn.arithmetic.pointOffer.eight_dance_steps;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/22
 * @Time: 16:08
 * @Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class DanceSteps {
    /**
     * 递归实现
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if (target == 0||target == 1){
            return 1;
        }
        return jumpFloor(target-1)+jumpFloor(target-2);
    }

    /**
     * 动态规划实现
     * @param target
     * @return
     */
    public int jumpFloor2(int target){
        int data[] = new int[target+1];
        data[0]=1;data[1]=1;
        for (int i=2;i<=target;i++){
            data[i] = data[i-1]+data[i-2];
        }
        return data[target];
    }

    public static void main(String[] args) {
        DanceSteps danceSteps = new DanceSteps();
        System.out.println(danceSteps.jumpFloor(2));
    }
}
