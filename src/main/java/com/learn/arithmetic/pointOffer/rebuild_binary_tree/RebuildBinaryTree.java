package com.learn.arithmetic.pointOffer.rebuild_binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/21
 * @Time: 15:02
 * @Description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入：
 *
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 *
 * 返回值：
 *
 * {1,2,5,3,4,6,7}
 */
public class RebuildBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int preLength = pre.length;
        if (preLength == 0){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        treeNode = getTreeNode(treeNode,pre,in);
        return treeNode;
    }

    public TreeNode getTreeNode(TreeNode treeNode,int []pre,int [] in){
        int preLength = pre.length;
        if (preLength == 1){
            return new TreeNode(pre[0]);
        }
        int rootValue = pre[0];
        int inIndex = getIndex(in,rootValue);
        int leftSubIn [] = new int[inIndex];
        System.arraycopy(in,0,leftSubIn,0,inIndex);
        int leftSubPre [] = new int[inIndex];
        System.arraycopy(pre,1,leftSubPre,0,inIndex);
        TreeNode leftNode = new TreeNode(pre[1]);
        treeNode.left = leftNode;
        //获取左子树
        getTreeNode(leftNode,leftSubPre,leftSubIn);
        int rightSubIn [] = new int[in.length-(inIndex+1)];
        System.arraycopy(in,inIndex+1,rightSubIn,in.length-1,in.length-(inIndex+1));
        int rightSubPre [] = new int[in.length-(inIndex+1)];
        System.arraycopy(pre,inIndex,rightSubPre,0,in.length-(inIndex+1));
        TreeNode rightNode = new TreeNode(pre[inIndex+1]);
        treeNode.right = rightNode;
        getTreeNode(rightNode,rightSubPre,rightSubIn);
        return treeNode;
    }

    public int getIndex(int []arr,int value){
        int result = -1;
        for (int i=0;i<arr.length;i++){
            if (arr[i] == value){
                result = i;
                break;
            }
        }
        return result;
    }

    public List<Object> levelTraversal(TreeNode treeNode){
        Queue queue = new LinkedBlockingDeque();
        queue.add(treeNode);
        Object value = 0;
        List<Object> levelTree = new ArrayList<>();
        while ((value = queue.poll())!=null){
            levelTree.add(value);
            queue.add(treeNode.left);
            queue.add(treeNode.right);
        }
        return levelTree;
    }

    public static void main(String[] args) {
        int pre [] = new int[]{1,2,3,4,5,6,7};
        int in [] = new int[]{3,2,4,1,6,5,7};
        RebuildBinaryTree rebuildBinaryTree = new RebuildBinaryTree();
        TreeNode treeNode = rebuildBinaryTree.reConstructBinaryTree(pre,in);
        List<Object> levelTree = rebuildBinaryTree.levelTraversal(treeNode);
        for (int i=0;i<levelTree.size();i++){
            System.out.println(levelTree.get(i)+" ");
        }

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
