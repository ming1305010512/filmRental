package com.learn.arithmetic.pointOffer.sixteen_merge_two_ordered_link;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/23
 * @Time: 16:11
 * @Description:
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入：
 *
 * {1,3,5},{2,4,6}
 *
 * 返回值：
 *
 * {1,2,3,4,5,6}
 */
public class MergeTwoOrderedLink {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(-1,null);
        ListNode pHead = result;
        while (list1!=null&&list2!=null){
            int oneValue = list1.val;
            int twoValue = list2.val;
            ListNode temNode = new ListNode(oneValue,null);
            if (oneValue<twoValue){
                temNode.val = oneValue;
                result.next = temNode;
                result = temNode;
                list1 = list1.next;
            }else if (oneValue == twoValue){
                temNode.val = oneValue;
                result.next = temNode;
                result = temNode;
                ListNode temNode2 = new ListNode(twoValue,null);
                result.next = temNode2;
                result = temNode2;
                list1 = list1.next;
                list2 = list2.next;
            }else {
                temNode.val = twoValue;
                result.next = temNode;
                result = temNode;
                list2 = list2.next;
            }
        }
        while (list1!=null){
            ListNode temNode = new ListNode(list1.val,null);
            result.next = temNode;
            result = temNode;
            list1 = list1.next;
        }
        while (list2!=null){
            ListNode temNode = new ListNode(list2.val,null);
            result.next = temNode;
            result = temNode;
            list2 = list2.next;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        MergeTwoOrderedLink mergeTwoOrderedLink = new MergeTwoOrderedLink();
        ListNode listNode1 = new ListNode(1,new ListNode(3,new ListNode(5,null)));
        ListNode listNode2 = null;
        ListNode resultNode = mergeTwoOrderedLink.Merge(listNode1,listNode2);
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