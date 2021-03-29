package com.learn.arithmetic.exercises;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/23
 * @Time: 16:48
 * @Description:两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class TowAdd {

    public static void main(String[] args) {
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9)));
        ListNode l1 = new ListNode(9);
        ListNode l3 = new TowAdd().addTwoNumbers(l1,l2);
        while (l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode l4 = l3;
        boolean carryFlag = false;
        while (l1!=null){
            ListNode tmp = new ListNode();
           int val1 = l1.val;
           if (l2!=null){
               int val2 = l2.val;
               tmp.val = val1+val2;
               if (carryFlag){
                   tmp.val = tmp.val+1;
               }
               if (tmp.val>=10){
                   carryFlag = true;
                   tmp.val = tmp.val%10;
               }else {
                   carryFlag = false;
               }
               l2 = l2.next;
           }else {
               tmp.val = val1;
               if (carryFlag){
                   tmp.val +=1;
               }
               if (tmp.val>=10){
                   carryFlag = true;
                   tmp.val = tmp.val%10;
               }else {
                   carryFlag = false;
               }
           }
           if (l2==null&&l1.next==null&&carryFlag){
               l3.next = tmp;
               ListNode tmp2 = new ListNode(1);
               l3.next.next = tmp2;
           }
           l1 = l1.next;
           l3.next = tmp;
           l3 = l3.next;
        }
        while (l2!=null){
            ListNode tmp = new ListNode();
            tmp.val = l2.val;
            if (carryFlag){
                tmp.val += 1;
                if (tmp.val>=10){
                    if (l2.next==null){
                        tmp.val = 0;
                        l3.next = tmp;
                        ListNode tmp2 = new ListNode(1);
                        l3.next.next = tmp2;
                    }else {
                        tmp.val = tmp.val%10;
                    }
                    carryFlag = true;
                }else {
                    carryFlag = false;
                }
            }
            l3.next = tmp;
            l3=l3.next;
            l2=l2.next;
        }
        return l4.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
