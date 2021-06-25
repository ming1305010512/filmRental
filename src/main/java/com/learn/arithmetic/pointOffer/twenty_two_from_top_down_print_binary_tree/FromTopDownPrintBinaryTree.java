package com.learn.arithmetic.pointOffer.twenty_two_from_top_down_print_binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/24
 * @Time: 20:40
 * @Description:
 */
public class FromTopDownPrintBinaryTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        MyQueue queue = new MyQueue();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode value = null;
        while ((value = queue.poll())!=null){
            result.add(value.val);
            TreeNode leftNode = value.left;
            TreeNode rightNode = value.right;
            if (leftNode!=null){
                queue.add(leftNode);
            }
            if (rightNode!=null){
                queue.add(rightNode);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        FromTopDownPrintBinaryTree binaryTreeImage = new FromTopDownPrintBinaryTree();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(6);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(11);
        ArrayList<Integer> result = binaryTreeImage.PrintFromTopToBottom(root1);
        for (int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }
}

class MyQueue{
    ArrayList<TreeNode> queue = new ArrayList<>();
    public void add(TreeNode value){
        queue.add(value);
    }
    public TreeNode poll(){
        if (queue.size()==0){
            return null;
        }
        TreeNode value = queue.get(0);
        queue.remove(0);
        return value;
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x) { val = x; }
}