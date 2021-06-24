package com.learn.arithmetic.pointOffer.nineteen_clockwise_print_matrix;

import java.util.ArrayList;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/24
 * @Time: 13:26
 * @Description:
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 *
 * [[1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12],
 * [13,14,15,16]]
 *
 * 则依次打印出数字
 *
 * [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
 *
 * 示例1
 * 输入：
 *
 * [[1,2],[3,4]]
 *
 * 返回值：
 *
 * [1,2,4,3]
 */
public class ClockwisePrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        ArrayList<Integer> data = new ArrayList<>();
        //分四步
        int rowStartIndex = 0;
        int colStartIndex = 0;
        while (rowLength>0&&colLength>0) {
            //遍历第一行
            for (int j = colStartIndex;j<colLength+colStartIndex;j++){
                data.add(matrix[rowStartIndex][j]);
            }
            //遍历最后一列
            for (int i = rowStartIndex+1;i<rowLength+rowStartIndex;i++){
                data.add(matrix[i][colLength+colStartIndex-1]);
            }
            //遍历最后一行
            for (int j = colLength+colStartIndex-2;j>=colStartIndex&&rowLength+rowStartIndex-1!=rowStartIndex;j--){
                data.add(matrix[rowLength+rowStartIndex-1][j]);
            }
            //遍历第一列
            //colLength+colStartIndex-1!=colStartIndex：只有一列的时候则无需进行这一步，第二步已经访问
            for (int i = rowLength+rowStartIndex-2;i>=rowStartIndex+1&&colLength+colStartIndex-1!=colStartIndex;i--){
                data.add(matrix[i][colStartIndex]);
            }
            rowStartIndex += 1;
            colStartIndex += 1;
            rowLength -= 2;
            colLength -= 2;
        }
        return data;
    }

    public static void main(String[] args) {
        ClockwisePrintMatrix clockwisePrintMatrix = new ClockwisePrintMatrix();
//        int [][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] matrix = new int[][]{{1},{2},{3},{4},{5}};
        ArrayList result = clockwisePrintMatrix.printMatrix(matrix);
        for (int i = 0;i<result.size();i++){
            System.out.print(result.get(i)+ " ");
        }
    }
}
