package com.learn.arithmetic.pointOffer.twenty_six_binary_order_tree_to_bothway_link;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/25
 * @Time: 16:34
 * @Description:
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
 *
 *
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出或者处理，示例中输出里面的英文，比如"From left to right are:"这样的，程序会根据你的返回值自动打印输出
 *
 * 示例:
 * 输入: {10,6,14,4,8,12,16}
 * 输出:From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
 * 解析:
 * 输入就是一棵二叉树，如上图，输出的时候会将这个双向链表从左到右输出，以及
 * 从右到左输出，确保答案的正确
 *
 * 示例1
 * 输入：
 *
 * {10,6,14,4,8,12,16}
 *
 * 返回值：
 *
 * From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
 *
 * 示例2
 * 输入：
 *
 * {5,4,#,3,#,2,#,1}
 *
 * 返回值：
 *
 * From left to right are:1,2,3,4,5;From right to left are:5,4,3,2,1;
 *
 * 说明：
 *
 *                     5
 *                   /
 *                 4
 *               /
 *             3
 *           /
 *         2
 *       /
 *     1
 * 树的形状如上图
 */
public class BinaryOrderTreeToBothwayLink {
    /**
     * 中序遍历树，然后调节节点
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {

    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x) { val = x; }
}