package com.learn.arithmetic.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/25
 * @Time: 15:50
 * @Description:无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class NoRepetitionSubstringLength {

    /**
     * 暴力求解：121 ms
     *
     * 基本思路：
     *  1、第一次子串的开始位置，将遍历到的字符传到HashMap中
     *  2、第二次依次遍历后续字符，判断是否在hashMap集合中，存在表示存在重复字符，跳出循环，回到第一步，不存在，将当前字符放入Map集合中
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i=0;i<s.length();i++){
            int temLength = 1;
            Map<Character,Integer> hashMap = new HashMap<>(16);
            hashMap.put(s.charAt(i),1);
            for (int j=i+1;j<s.length();j++){
               char b = s.charAt(j);
               if (hashMap.get(b)!=null){
                   break;
               }else {
                   hashMap.put(b,1);
                   temLength++;
               }
            }
            maxLength = Math.max(maxLength,temLength);
        }
        return maxLength;
    }

    /**
     * 优化后的，但是效果和第一种差不多：98 ms
     * 基本思路：
     * 1、遍历子串的开始位置
     * 2、判断字符是否存在hashMap中，不存在，表示不重复，将字符加入集合中，存在，遍历位置回退到上次开始位置的下一个字符
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        Map<Character,Integer> hashMap = new HashMap<>(16);
        int temLength = 0;
        for (int i=0;i<s.length();i++){
            if (hashMap.get(s.charAt(i))!=null){
                i = i-temLength;
                temLength = 0;
                hashMap.clear();
            }else {
                hashMap.put(s.charAt(i),1);
                temLength++;
            }
            maxLength = Math.max(maxLength,temLength);
        }
        return maxLength;
    }

    /**
     * 使用滑动窗口
     *  基本思路：
     *  1、创建左右两个指针，指向子串的开始位置和结束位置，形成一个窗口，
     *  2、然后右移右指针，且将值存入到Map中，直到存在重复的数据，
     *  3、存在重复数据后右移左指针，移除之前左指针在map中的值，回到2
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;
        Map<Character,Integer> hashMap = new HashMap<>(16);
        int leftPoint = 0;
        int rightPoint = 0;
        while (leftPoint<s.length()){
            if (leftPoint==0){
                hashMap.put(s.charAt(leftPoint),1);
            }
            if (rightPoint+1<s.length()&&hashMap.get(s.charAt(rightPoint+1))==null){
                rightPoint++;
                hashMap.put(s.charAt(rightPoint),1);
            }else {
                hashMap.put(s.charAt(leftPoint),null);
                leftPoint++;
            }
            if (rightPoint<leftPoint){
                hashMap.put(s.charAt(rightPoint),1);
                rightPoint = leftPoint;
            }
            maxLength = Math.max(maxLength,rightPoint-leftPoint+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new NoRepetitionSubstringLength().lengthOfLongestSubstring3(s));
    }
}
