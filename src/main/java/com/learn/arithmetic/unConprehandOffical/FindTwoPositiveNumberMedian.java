package com.learn.arithmetic.unConprehandOffical;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/26
 * @Time: 9:01
 * @Description:寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 */
public class FindTwoPositiveNumberMedian {

    /**
     * 基本思路
     * 1、采用顺序列表合并算法的思想，分别遍历两个数组，创建一个数组mergeResult用来合并为单个的有序数组，nums1从i开始遍历，nums2从j开始遍历
     * 2、如果num1[i]<num2[j],nums1[i]加入mergeResult中，i递增一位，num1[i]>nums2[j]的话,nums2[j]加入mergeResult中，j递增一位，如果相等，
     *  两个都加入mergeResult,i和j都递增一位
     * 3、第一次遍历后将剩余数组加入到mergeResult中，如果nums1先遍历完，遍历剩余的nums2加入mergeResult中
     * 4、最后根据总长度找出中位数的索引，然后求解
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int sumLength = nums1.length+nums2.length;
        int medianIndex = sumLength/2-1;
        int remainderValue = sumLength%2;
        int tmpMedianIndex = 0;
        int []mergeResult = new int[sumLength];
        int i=0,j=0;
        for (;i<nums1Length&&j<nums2Length;){
           if (nums1[i]<nums2[j]){
               mergeResult[tmpMedianIndex++] = nums1[i];
               i++;
           }else if (nums1[i]>nums2[j]){
               mergeResult[tmpMedianIndex++] = nums2[j];
               j++;
           }else {
               mergeResult[tmpMedianIndex++] = nums1[i];
               mergeResult[tmpMedianIndex++] = nums2[j];
               i++;j++;
           }
        }
        if (i>=nums1Length){
            while (j<nums2Length){
                mergeResult[tmpMedianIndex++] = nums2[j];
                j++;
            }
        }else {
            while (i<nums1Length){
                mergeResult[tmpMedianIndex++] = nums1[i];
                i++;
            }
        }
        double medianValue = -1;
        if (remainderValue==0){
            medianValue =  (mergeResult[medianIndex]+mergeResult[medianIndex+1])/2.0;
        }else {
            medianValue = mergeResult[medianIndex+1];
        }
        return medianValue;
    }


    public static void main(String[] args) {
        int nums1[] = new int[]{2};
        int nums2[] = new int[]{1,3,4};
        System.out.println(new FindTwoPositiveNumberMedian().findMedianSortedArrays(nums1,nums2));
    }
}
