package com.learn.arithmetic.pointOffer.four_rebuild_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
        //叶子节点处理
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
        int nextValue = pre[1];
        //判断下一个节点是左子节点还是右子节点
        int nextIndex = getIndex(in,nextValue);
        //下一节点为右子节点
        if (nextIndex<inIndex) {
            TreeNode leftNode = new TreeNode(pre[1]);
            treeNode.left = leftNode;
            //获取左子树
            getTreeNode(leftNode, leftSubPre, leftSubIn);
        }

        int rightSubIn [] = new int[in.length-(inIndex+1)];
        System.arraycopy(in,inIndex+1,rightSubIn,0,in.length-(inIndex+1));
        int rightSubPre [] = new int[in.length-(inIndex+1)];
        System.arraycopy(pre,inIndex+1,rightSubPre,0,in.length-(inIndex+1));
        //右子节点边界为在子树的最后一个节点
        if (in.length==inIndex+1){
            return treeNode;
        }
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

    public static void main(String[] args) {
        int pre [] = new int[]{1,2,4,3,5,6};
        int in [] = new int[]{4,2,1,5,3,6};
        RebuildBinaryTree rebuildBinaryTree = new RebuildBinaryTree();
        TreeNode treeNode = rebuildBinaryTree.reConstructBinaryTree(pre,in);
        List<TreeNode> levelTree = rebuildBinaryTree.levelTraversal(treeNode);
        for (int i=0;i<levelTree.size();i++){
            System.out.print(levelTree.get(i).val+" ");
        }

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
