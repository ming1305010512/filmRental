package com.learn.arithmetic.exercises;

import java.util.TreeMap;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/24
 * @Time: 11:06
 * @Description:
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 *
 * 示例 2：
 *
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 *
 */
public class OneThreeTwoModel {

    public static void main(String[] args) {
        int [] nums = new int[]{3,1,4,2};
        System.out.println(new OneThreeTwoModel().find132pattern2(nums));
    }

    //暴力法
    public boolean find132pattern(int[] nums) {

        boolean flag = false;
        for (int i =0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[i]<nums[k]&&nums[k]<nums[j]){
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 思路：枚举最大的那个值，我们只需要从左到右枚举3的下标j
     * 1、由于1是模式中的最小值，因此我们在枚举j的同时，维护数组a中左侧元素a[0,j-1]的最小值，即为1对应的元素a[i].需要注意的是
     *     只有a[i]<a[j]时，a[i]才能作为1对应的元素
     * 2、由于2是模式中的次小值，因此我们可以使用一个有序集合（例如平衡树）维护数组a中右侧元素a[j+1...n-1]中的所有值，当我们确定了a[i]和a[j]后，
     *     只需要在有序集合中查询严格比a[i]大的那个最小元素，即为a[k]，需要注意的是,只有a[k]<a[j]时，a[k]才满足
     *
     */
    public boolean find132pattern2(int[] nums){
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }
}
