package com.learn.arithmetic.pointOffer.seventeen_tree_substructure;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/24
 * @Time: 9:02
 * @Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入：
 *
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 *
 * 返回值：
 *
 * true
 */
public class TreeSubstructure {
    /**
     * 使用层次遍历主树
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //层序遍历主树
        Queue queue = new LinkedBlockingDeque();
        queue.add(root1);
        TreeNode treeNode = null;
        boolean resultFlag = false;
        while ((treeNode = (TreeNode) queue.poll())!=null){
            TreeNode leftNode = treeNode.left;
            TreeNode rightNode = treeNode.right;
            if (leftNode!=null){
                queue.add(treeNode.left);
            }
            if (rightNode!=null){
                queue.add(treeNode.right);
            }
            //根节点相等
            if (treeNode.val == root2.val){
                boolean flag = compareRootNode(treeNode,root2);
                if (flag){
                    resultFlag = true;
                    break;
                }
            }
        }
        return resultFlag;
    }

    /**
     * 递归遍历主树
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree2(TreeNode root1,TreeNode root2) {
        if (root1==null){
            return false;
        }
        if (root2 == null){
            return false;
        }
        boolean flag = compareRootNode(root1,root2);
        if (!flag){
            boolean leftFlag = HasSubtree2(root1.left,root2);
            if (leftFlag){
                return true;
            }else {
                boolean rightFlag = HasSubtree2(root1.right,root2);
                if (rightFlag){
                    return true;
                }else {
                    return false;
                }
            }
        }else {
            return true;
        }
    }

    public boolean compareRootNode(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            //比较下一左子节点
            boolean resultLeft = compareRootNode(root1.left,root2.left);
            boolean resultRight = compareRootNode(root1.right,root2.right);
            if (resultLeft&&resultRight){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeSubstructure treeSubstructure = new TreeSubstructure();
        TreeNode root1 = new TreeNode(8);
        root1.right = new TreeNode(8);
        root1.right.right = new TreeNode(9);
        root1.right.right.right = new TreeNode(2);
        root1.right.right.right.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(8);
        root2.right = new TreeNode(9);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(2);
        boolean result = treeSubstructure.HasSubtree2(root1,root2);
        System.out.println(result);
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
