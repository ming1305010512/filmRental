package com.learn.arithmetic.pointOffer.twenty_five_complex_link_copy;

import java.util.ArrayList;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/25
 * @Time: 14:57
 * @Description:
 *  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）。 下图是一个含有5个结点的复杂链表。图中实线箭头表示next指针，虚线箭头表示random指针。为简单起见，指向null的指针没有画出。
 *
 * 示例:
 * 输入:{1,2,3,4,5,3,5,#,2,#}
 * 输出:{1,2,3,4,5,3,5,#,2,#}
 * 解析:我们将链表分为两段，前半部分{1,2,3,4,5}为ListNode，后半部分{3,5,#,2,#}是随机指针域表示。
 * 以上示例前半部分可以表示链表为的ListNode:1->2->3->4->5
 * 后半部分，3，5，#，2，#分别的表示为
 * 1的位置指向3，2的位置指向5，3的位置指向null，4的位置指向2，5的位置指向null
 * 如下图:
 *
 * 示例1
 * 输入：
 *
 * {1,2,3,4,5,3,5,#,2,#}
 *
 * 返回值：
 *
 * {1,2,3,4,5,3,5,#,2,#}
 */
public class ComplexLinkCopy {

    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode resultNode = new RandomListNode(-1);
        RandomListNode randomListNode = pHead;
        RandomListNode resultTemNode = resultNode;
        //第一次遍历，复制next链接的链表
        while (pHead!=null){
            RandomListNode currentNode = new RandomListNode(pHead.label);
            resultNode.next = currentNode;
            resultNode = resultNode.next;
            pHead = pHead.next;
        }
        RandomListNode dataNode = resultTemNode.next;
        //在次遍历，处理随机指针
        while (randomListNode!=null){
            RandomListNode randomNode = randomListNode.random;
            RandomListNode copyNode = resultTemNode.next;
            while (copyNode!=null) {
                if (randomNode != null && randomNode.label == copyNode.label) {
                    dataNode.random = copyNode;
                }
                copyNode = copyNode.next;
            }
            randomListNode = randomListNode.next;
            dataNode = dataNode.next;
        }
        return resultTemNode.next;
    }

    public static void main(String[] args) {
        ComplexLinkCopy complexLinkCopy = new ComplexLinkCopy();
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        RandomListNode randomListNode5 = new RandomListNode(5);
        randomListNode1.next = randomListNode2;
        randomListNode1.random = randomListNode3;
        randomListNode2.next = randomListNode3;
        randomListNode2.random = randomListNode5;
        randomListNode3.next = randomListNode4;
        randomListNode4.next = randomListNode5;
        randomListNode4.random = randomListNode2;
        RandomListNode resultListNode = complexLinkCopy.Clone(randomListNode1);
        System.out.println(resultListNode);
    }
}



class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    RandomListNode(int label,RandomListNode next,RandomListNode random) {
        this.label = label;
        this.next = next;
        this.random = random;
    }
}