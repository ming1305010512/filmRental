package com.learn.arithmetic.exercises;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/25
 * @Time: 10:34
 * @Description:删除列表中的重复元素2
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 */
public class DeleteOrderListRepetition {

    /**
     * 基本思路：
     * 1、增加一个虚拟的头结点和尾结点，遍历链表，存储上一个节点preNode,
     * 2、当前节点currentNode和下一节点nextNode值比较，相等,直接指向下一个节点，且标记eqFlag为true，preNode不变，不相等
     * 判断eqFlag是否为true，是将preNode指向nextNode,重置eqFlag为false;eqFlag为false,preNode指向currentNode,currentNode指向nextNode,
     *
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode preNode = new ListNode(head.val - 1, head);
        boolean eqFlag = false;
        boolean tailFlag = false;
        ListNode result = preNode;
        int i = 0;
        while (head.next != null) {
            if (head.val != head.next.val) {
                head = head.next;
                if (eqFlag) {
                    preNode.next = head;
                } else {
                    preNode = preNode.next;
                }
                eqFlag = false;
            } else {
                head = head.next;
                preNode.next = head;
                eqFlag = true;
            }
            if (i == 0 && head.next == null) {
                head.next = new ListNode(head.val + 1);
                tailFlag = true;
                i++;
            }
        }
        if (tailFlag) {
            preNode.next = null;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5,new ListNode(5))))))));
        ListNode listNode2 = new ListNode(1);
        ListNode result = new DeleteOrderListRepetition().deleteDuplicates(listNode);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
