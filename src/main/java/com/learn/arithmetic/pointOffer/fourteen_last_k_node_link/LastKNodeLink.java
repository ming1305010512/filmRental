package com.learn.arithmetic.pointOffer.fourteen_last_k_node_link;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 15:31
 * @Description:
 *  输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * 示例1
 * 输入：
 *
 * {1,2,3,4,5},1
 *
 * 返回值：
 *
 * {5}
 *
 */
public class LastKNodeLink {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        int length = 0;
        ListNode listNode = pHead;
        while (pHead!=null){
            length++;
            pHead = pHead.next;
        }
        int resultHeadIndex = length-k;
        if (resultHeadIndex<0){
            return null;
        }else {
            for (int i=1;i<=resultHeadIndex;i++){
                listNode = listNode.next;
            }
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        LastKNodeLink lastKNodeLink = new LastKNodeLink();
        ListNode resultNode = lastKNodeLink.FindKthToTail(listNode,3);
        while (resultNode!=null){
            System.out.print(resultNode.val+" ");
            resultNode = resultNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}