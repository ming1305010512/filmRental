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
    public static int indexKmp(String mainStr,String subStr,int pos){
        char mainStrChar[] = mainStr.toCharArray();
        char subStrChar[] = subStr.toCharArray();
        int next[] = new int[subStrChar.length];
        getNext(subStrChar,next);
        //k是子串实际位置，j是标记（用于获取next的值）;i是主串位置
        int i=pos,j=1,k=0;
        while (i<mainStrChar.length&&k<subStrChar.length){//两个字符串均没到末尾
            if (j==0||mainStrChar[i]==subStrChar[k]){
                i++;
                j++;
                k=j-1;
            }else {
                j = next[k];
                if (j==0){
                    k=0;
                }else {
                    k = j - 1;
                }
            }
        }
        if (j>=subStrChar.length) return i-subStrChar.length;
        return -1;
    }

    /**
     * 获取子串的next值
     * @param subStrChar
     * @param next
     */
    private static void getNext(char []subStrChar,int next[]) {
        int i=1,j=0;
        next[1]=0;
        while (i<subStrChar.length){
            if (j==0||subStrChar[i-1]==subStrChar[j-1]){
                j++;
                next[i++]=j;
            }else {
                j = next[j]-1;
            }
        }
    }

    public static void main(String[] args) {
        String mainStr = "abcsdfdfhjababccakfd";
        String subStr = "abab";
        int position = indexKmp(mainStr,subStr,0);
        if (position!=-1) {
            System.out.println("匹配成功，匹配开始位置为"+(position+1));
        }else {
            System.out.println("匹配失败");
        }
    }
}
