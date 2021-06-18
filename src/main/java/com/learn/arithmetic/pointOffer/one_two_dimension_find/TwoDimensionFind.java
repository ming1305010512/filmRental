package com.learn.arithmetic.pointOffer.one_two_dimension_find;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/17
 * @Time: 20:41
 * @Description:
 *  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 *   [1,2,8,9],
 *   [2,4,9,12],
 *   [4,7,10,13],
 *   [6,8,11,15]
 * ]
 *
 * 给定 target = 7，返回 true。
 *
 * 给定 target = 3，返回 false。
 */
public class TwoDimensionFind {
    public boolean find(int target,int [][] array){
        if (array.length==0){
            return false;
        }
        if (array[0].length == 0){
            return false;
        }
        int rowLength = array[0].length;
        int mid = array[0][rowLength-1];
        int j = rowLength - 1;
        int i = 0;
        boolean result = false;
        while (j>0 && i<array.length-1){
            if (mid>target){
                j--;
                mid = array[i][j];
            }else if (mid < target){
                i++;
                mid = array[i][j];
            }
            if (mid == target){
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 7;
        int array[][] = {{}};
        System.out.println(new TwoDimensionFind().find(target,array));
    }
}
