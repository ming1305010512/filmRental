package com.learn.arithmetic.exercises;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/26
 * @Time: 8:45
 * @Description:删除列表中的重复元素
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 示例 1：
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 */
public class DeleteOrderListRepetition2 {

    /**
     * 基本思路
     * 1、设定一个前置节点preNode，遍历列表，当前节点currentNode和preNode比较，相同,preNode指向当前节点的下一节点nextNode，不同preNode像后移
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = head;
        ListNode result = preNode;
        if (head==null){
            return head;
        }
        while (head.next!=null){
            head = head.next;
            if (head.val==preNode.val){
                preNode.next = head.next;
            }else {
                preNode = preNode.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3)))));
        ListNode result = new DeleteOrderListRepetition2().deleteDuplicates(head);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
