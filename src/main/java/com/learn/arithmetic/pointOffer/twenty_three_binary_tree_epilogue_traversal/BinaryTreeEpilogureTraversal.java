package com.learn.arithmetic.pointOffer.twenty_three_binary_tree_epilogue_traversal;

import java.util.Stack;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/25
 * @Time: 8:39
 * @Description:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * 示例1
 * 输入：
 *
 * [4,8,6,12,16,14,10]
 *
 * 返回值：
 *
 * true
 */
public class BinaryTreeEpilogureTraversal {

    /**
     * 使用递归
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null){
            return false;
        }
        if (sequence.length == 0){
            return false;
        }
        return JudgeBinaryOrderTree(sequence,0,sequence.length-1);
    }

    public boolean JudgeBinaryOrderTree(int []sequence,int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return true;
        }
        int i = startIndex;
        for (;i<=endIndex;){
            if (sequence[i]<sequence[endIndex]){
                i++;
            }else {
                break;
            }
        }
        for (int j=i;j<=endIndex;j++){
            if (sequence[j]<sequence[endIndex]){
                return false;
            }
        }
        boolean result = JudgeBinaryOrderTree(sequence,startIndex,i-1)&&JudgeBinaryOrderTree(sequence,i,endIndex-1);
        return result;
    }

    public static void main(String[] args) {
        int [] sequence = new int[]{2,7,3,6,9,8,5};
        BinaryTreeEpilogureTraversal binaryTreeEpilogureTraversal = new BinaryTreeEpilogureTraversal();
        System.out.println(binaryTreeEpilogureTraversal.VerifySquenceOfBST(sequence));
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x) { val = x; }
}
