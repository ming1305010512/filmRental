package com.learn.arithmetic.pointOffer.twenty_four_binary_tree_node_sum_path;

import java.util.ArrayList;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/25
 * @Time: 11:21
 * @Description:
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入：
 *
 * {10,5,12,4,7},22
 *
 * 返回值：
 *
 * [[10,5,7],[10,12]]
 *
 * 示例2
 * 输入：
 *
 * {10,5,12,4,7},15
 *
 * 返回值：
 *
 * []
 */
public class BinaryTreeNodeSumPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root,target,path,result);
        return result;
    }

    /**
     * 先序遍历
     * @param root
     * @param target
     * @param path  存储遍历的存路径
     * @param result    存储符合条件的路径
     */
    public void preOrder(TreeNode root,int target,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> result){
        if (root!=null) {
            path.add(root.val);
            if (target == root.val && root.left == null && root.right == null) {
                ArrayList<Integer> data = new ArrayList<>(path);
                result.add(data);
            }

            preOrder(root.left, target - root.val, path, result);
            preOrder(root.right, target - root.val, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNodeSumPath binaryTreeNodeSumPath = new BinaryTreeNodeSumPath();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(12);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> result = binaryTreeNodeSumPath.FindPath(treeNode,22);
        for (int i=0;i<result.size();i++){
            ArrayList<Integer> data = result.get(i);
            for (int j = 0;j<data.size();j++){
                if (j==data.size()-1){
                    System.out.println(data.get(j));
                }else {
                    System.out.print(data.get(j) + " ");
                }
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x) { val = x; }
}
