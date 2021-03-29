package com.learn.arithmetic.exercises;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/26
 * @Time: 14:20
 * @Description:最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 */
public class LongestManacher {


    /**
     * 基本思路：
     * 1、遍历字符，从最小的两种边界回文串开始向外扩展（两种边界包括一个字符和两个相同的字符），如果左右两边为相同字符，继续向外扩展，直到不是回文串
     * 2、从中选出长度最长的子串，无论边界字符为一个还是两个，开始位置和结束位置都可由一下公式计算
     *  start = i-(length-1)/2,end = i+length/2 ;其中i为边界字段的位置，length为子串长度，start为回文串的开始位置，end为回文串的结束位置
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        String maxManacher = s.substring(0,1);
        int maxLength = 1;
        for (int i=0;i<s.length();i++){
            int maxLength1 = expandPalindromic(maxLength,i,s,0);
            int maxLength2 = expandPalindromic(maxLength,i,s,1);
            int length = Math.max(maxLength1,maxLength2);
            if (length>maxLength){
                maxLength = length;
                maxManacher = s.substring(i-(length-1)/2,i+length/2+1);
            }
        }
        return maxManacher;
    }

    public int expandPalindromic(int maxLength,int i,String s,int k){
        for (int j=0;i-j>=0&&i+k<s.length();){
            if (s.charAt(i + k) != s.charAt(i - j)) {
                break;
            } else {
                int length = k + j + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
                k++;
                j++;
            }
        }
        return maxLength;
    }


    /**
     * 动态规范的理解：
     * 一类活动的过程，可将过程分成若干互相联系的阶段，每个阶段都要做出决策，从而使整个过程达到最好的效果，各个阶段的决策依赖于当前面临的
     * 状态，又影响以后的发展，当各个阶段决策确定后，就组成一个决策序列，因此也就确定了整个过程的一条活动路线，这种把问题看做是一个前后关联
     * 具有链状结构的多阶段过程称为多阶段决策过程，在多阶段决策问题中，各个阶段采取的决策，依赖于当前状态，又随即引起状态的转移，一个决策序列就是
     * 在变化的状态中产生的
     *
     * 动态规范的基本思想：
     * 其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解，与分治算法不同，适合于动态规范求解的问题，经分解
     * 得到子问题往往不是互相独立的，一般会用一个表来记录所有已解的子问题的答案，不管该子问题以后是否被用到，只要他被计算过，就将其结果填入表中，需要时
     * 在找出以求得的答案，可以避免大量的重复计算
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "tattarrattat";
        System.out.println(new LongestManacher().longestPalindrome(s));
    }
}
