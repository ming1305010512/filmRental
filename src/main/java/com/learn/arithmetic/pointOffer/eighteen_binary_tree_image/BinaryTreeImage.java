package com.learn.arithmetic.pointOffer.eighteen_binary_tree_image;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/24
 * @Time: 11:07
 * @Description:
 *  操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 比如：    源二叉树
 *             8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *         镜像二叉树
 *             8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 *
 * 示例1
 * 输入：
 *
 * {8,6,10,5,7,9,11}
 *
 * 返回值：
 *
 * {8,10,6,11,9,7,5}
 */
public class BinaryTreeImage {
    /**
     * 使用递归
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot==null){
            return null;
        }
        //交换左右子树
        TreeNode tempNode = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tempNode;
        //处理左子树
        Mirror(pRoot.left);
        //处理右子树
        Mirror(pRoot.right);
        return pRoot;
    }

    public static void main(String[] args) {
        BinaryTreeImage binaryTreeImage = new BinaryTreeImage();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(6);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(11);
        TreeNode treeNode = binaryTreeImage.Mirror(root1);
        List<TreeNode> levelTree = binaryTreeImage.levelTraversal(treeNode);
        for (int i=0;i<levelTree.size();i++){
            System.out.print(levelTree.get(i).val+" ");
        }

    }

    public List<TreeNode> levelTraversal(TreeNode treeNode){
        Queue queue = new LinkedBlockingDeque();
        queue.add(treeNode);
        TreeNode value = null;
        List<TreeNode> levelTree = new ArrayList<>();
        while ((value = (TreeNode) queue.poll())!=null){
            levelTree.add(value);
            TreeNode leftNode = value.left;
            TreeNode rightNode = value.right;
            if (leftNode!=null) {
                queue.add(value.left);
            }
            if (rightNode!=null) {
                queue.add(value.right);
            }
        }
        return levelTree;
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}