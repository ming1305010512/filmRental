package com.learn.arithmetic.pointOffer.sixteen_merge_two_ordered_link;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 17:18
 * @Description:
 */
public class OtherWayMergeTwoOrderedLink {
    /**
     * 使用递归求解
     * 方法每次返回两个链表的最小值，然后把它连接到已排好序的列表中
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode resultNode = null;
        if (list1.val <= list2.val){
            list1.next = Merge(list1.next,list2);
            resultNode = list1;
        }
        if (list2.val <= list1.val){
            list2.next = Merge(list1,list2.next);
            resultNode = list2;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        OtherWayMergeTwoOrderedLink otherWayMergeTwoOrderedLink = new OtherWayMergeTwoOrderedLink();
        ListNode listNode1 = new ListNode(1,new ListNode(3,new ListNode(5,null)));
        ListNode listNode2 = new ListNode(2,new ListNode(4,new ListNode(6,null)));
        ListNode resultNode = otherWayMergeTwoOrderedLink.Merge(listNode1,listNode2);
        while (resultNode!=null){
            System.out.print(resultNode.val+" ");
            resultNode = resultNode.next;
        }
    }
}
