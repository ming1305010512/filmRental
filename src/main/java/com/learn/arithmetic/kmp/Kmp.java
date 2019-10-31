package com.learn.arithmetic.kmp;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/31
 * @Time:19:48
 * @Description:
 */
public class Kmp {

    /**
     * kmp算法
     * @param mainStr 主串
     * @param subStr 子串
     * @param pos 从主串的pos位置开始匹配 pos>1且小于主串的长度
     * @return
     */
    public int indexKmp(String mainStr,String subStr,int pos){
        char mainStrChar[] = mainStr.toCharArray();
        char subStrChar[] = subStr.toCharArray();
        int i=pos,j=1;
        while (i<mainStrChar.length&&j<subStrChar.length){//两个字符串均没到末尾
            if (j==0||mainStrChar[i]==subStrChar[j]){
                i++;
                j++;
            }else {
                j = next(j);
            }
        }
        return 0;
    }

    private int next(int j) {
    }
}
