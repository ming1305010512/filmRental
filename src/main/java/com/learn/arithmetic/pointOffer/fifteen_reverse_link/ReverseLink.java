package com.learn.arithmetic.pointOffer.fifteen_reverse_link;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 15:55
 * @Description:
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 示例1
 * 输入：
 *
 * {1,2,3}
 *
 * 返回值：
 *
 * {3,2,1}
 */
public class ReverseLink {
    public ListNode ReverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode preNode = null;
        while (currentNode!=null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        ListNode resultNode = reverseLink.ReverseList(listNode);
        while (resultNode!=null){
            System.out.print(resultNode.val+" ");
            resultNode = resultNode.next;
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
