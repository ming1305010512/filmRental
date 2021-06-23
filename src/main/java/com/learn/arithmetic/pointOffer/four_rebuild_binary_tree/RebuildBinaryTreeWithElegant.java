package com.learn.arithmetic.pointOffer.four_rebuild_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/22
 * @Time: 14:17
 * @Description:
 */
public class RebuildBinaryTreeWithElegant {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return rebuild(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode rebuild(int [] pre,int preLeft,int preRight,int [] in ,int inLeft,int inRight){
        if (preLeft>preRight){
            return null;
        }
        TreeNode rootNode = new TreeNode(pre[preLeft]);
        for (int i= inLeft;i<=inRight;i++){
            if (in[i]==rootNode.val){
                rootNode.left = rebuild(pre,preLeft+1,preLeft+i,in,inLeft,i-1);
                rootNode.right = rebuild(pre,preLeft+i+1,preRight,in,i+1,inRight);
                break;
            }
        }
        return rootNode;
    }

    public static void main(String[] args) {
        int pre [] = new int[]{1,2,4,3,5,6};
        int in [] = new int[]{4,2,1,5,3,6};
        RebuildBinaryTreeWithElegant rebuildBinaryTree = new RebuildBinaryTreeWithElegant();
        TreeNode treeNode = rebuildBinaryTree.reConstructBinaryTree(pre,in);
        List<TreeNode> levelTree = rebuildBinaryTree.levelTraversal(treeNode);
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
