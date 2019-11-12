package com.learn.java.Binary;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/23
 * @Time:17:26
 */
public class BinaryTest {

    private static String toBinary(int num,int base){
        StringBuffer stringBuffer = new StringBuffer("");
       int []result = new int[64];
       int j = 1;
       int k = 0;
       while(j!=0){
           int remainder = num%base;
           j = num/base;
           num = j;
           result[result.length-1-k] = remainder;
           k++;
       }
       for (int i=0;i<result.length;i++){
           stringBuffer.append(result[i]);
       }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println("4的二进制表示："+toBinary(4,2));
        System.out.println("4的8进制表示："+toBinary(4,8));
        System.out.println("4的8进制表示："+Integer.toBinaryString(4));
        System.out.println("4的8进制表示："+Integer.toString(4,2));
        String.format("%02d",Integer.parseInt(Integer.toBinaryString(3)));

    }

}
