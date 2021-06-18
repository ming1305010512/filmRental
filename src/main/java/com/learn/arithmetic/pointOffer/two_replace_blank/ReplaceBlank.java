package com.learn.arithmetic.pointOffer.two_replace_blank;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/18
 * @Time: 15:02
 * @Description:
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 示例1
 * 输入：
 *
 * "We Are Happy"
 *
 * 返回值：
 *
 * "We%20Are%20Happy"
 */
public class ReplaceBlank {

    public String replaceSpace(String s){
        int length = s.length();
        StringBuffer result = new StringBuffer("");
        for (int i=0;i<length;i++){
            if (s.charAt(i)== ' '){
                result.append("%20");
            }else {
                result.append(String.valueOf(s.charAt(i)));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(new ReplaceBlank().replaceSpace(s));
    }
}
