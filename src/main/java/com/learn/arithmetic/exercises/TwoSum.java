package com.learn.arithmetic.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/23
 * @Time: 16:07
 * @Description: 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案
 *示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] data = new int[]{6,-6,4,0};
        int [] result = new TwoSum().twoSum2(data,0);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    //暴力求解
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    //使用hashMap求解
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int [] result = new int[2];
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int tmp = target - nums[i];
            if (map.get(tmp)!=null&&map.get(tmp)!=i){
                result[0] = i;
                result[1] = map.get(tmp);
            }
        }
        return result;
    }
}
