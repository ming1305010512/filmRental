package com.learn.arithmetic.pointOffer.thirteen_make_odd_pre_with_even;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 14:45
 * @Description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 示例1
 * 输入：
 *
 * [1,2,3,4]
 *
 * 返回值：
 *
 * [1,3,2,4]
 *
 * 示例2
 * 输入：
 *
 * [2,4,6,5,7]
 *
 * 返回值：
 *
 * [5,7,2,4,6]
 */
public class MakeOddPreWithEven {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        //记录偶数的开始位置和结束位置
        int oddStartIndex = 0;
        int oddEndIndex = -1;
        for (int i=0;i<array.length&&oddEndIndex<array.length;i++){
            if ((array[i]&1)!=0){
                int value = array[i];
                for (int j=oddEndIndex;j>=oddStartIndex;j--){
                    array[j+1] = array[j];
                }
                array[oddStartIndex] = value;
                oddStartIndex++;
                oddEndIndex++;
            }else {
                oddEndIndex++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        MakeOddPreWithEven makeOddPreWithEven = new MakeOddPreWithEven();
        int array[] = new int[]{1,4,6,5,7};
        int [] resultArray = makeOddPreWithEven.reOrderArray(array);
        for (int i=0;i<resultArray.length;i++){
            System.out.print(resultArray[i]+" ");
        }
    }
}
