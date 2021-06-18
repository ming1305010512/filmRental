package com.learn.arithmetic.pointOffer.three_traversal_link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/18
 * @Time: 15:28
 * @Description:
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * 示例1
 * 输入：
 *
 * {1,2,3}
 *
 * 返回值：
 *
 * [3,2,1]
 *
 * 示例2
 * 输入：
 *
 * {67,0,24,58}
 *
 * 返回值：
 *
 * [58,24,0,67]
 */
public class TraversalLink {

    /**
     * 先遍历列表，然后反转
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (listNode!=null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        int size = result.size();
        int index = size/2;
        //手动进行反转排列
        for (int i=index;i+1<size;i++){
            int preIndex = size - (i+2);
            int t = result.get(preIndex);
            result.set(preIndex,result.get(i+1));
            result.set(i+1,t);
        }
        //长度为偶数大小的需要处理下边界
        if (size%2==0&&size>1){
            int t = result.get(index-1);
            result.set(index-1,result.get(index));
            result.set(index,t);
        }
        return result;
    }

    /**
     * 使用递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null){
            return result;
        }
        result = printListFromTailToHead2(listNode.next);
        result.add(listNode.val);
        return result;
    }

    /**
     * 反转链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode preListNode = null;
        while (listNode!=null){
            ListNode temptListNode = listNode.next;
            listNode.next = preListNode;
            preListNode = listNode;
            listNode = temptListNode;

        }
        while (listNode!=null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        return result;
    }



    public static void main(String[] args) {
        ListNode listNode = new ListNode(67,new ListNode(0,new ListNode(24,new ListNode(58,null))));
        ArrayList result = new TraversalLink().printListFromTailToHead3(listNode);
        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
