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
 * @Time: 11:26
 * @Description:
 */
public class TraversalWayBinaryTreeImage {

    public TreeNode Mirror (TreeNode pRoot) {
        Queue queue = new LinkedList();
        queue.add(pRoot);
        TreeNode value = null;
        while ((value= (TreeNode) queue.poll())!=null){
            TreeNode leftNode = value.left;
            TreeNode rightNode = value.right;
            if (leftNode!=null){
                queue.add(leftNode);
            }
            if (rightNode!=null){
                queue.add(rightNode);
            }
            //交换
            value.left = rightNode;
            value.right = leftNode;
        }
        return pRoot;
    }

    public static void main(String[] args) {
        TraversalWayBinaryTreeImage binaryTreeImage = new TraversalWayBinaryTreeImage();
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
