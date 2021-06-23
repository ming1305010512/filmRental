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
        if (list1.val <= list2.val){
            list1
        }
    }
}
