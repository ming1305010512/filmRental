package com.learn.arithmetic.pointOffer.five_tow_stack_to_queue;

import java.util.Stack;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/22
 * @Time: 14:44
 * @Description:
 *  用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 *
 * 示例:
 * 输入:
 * ["PSH1","PSH2","POP","POP"]
 * 返回:
 * 1,2
 * 解析:
 * "PSH1":代表将1插入队列尾部
 * "PSH2":代表将2插入队列尾部
 * "POP“:代表删除一个元素，先进先出=>返回1
 * "POP“:代表删除一个元素，先进先出=>返回2
 * 示例1
 * 输入：
 *
 * ["PSH1","PSH2","POP","POP"]
 *
 * 返回值：
 *
 * 1,2
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            Integer value = stack2.pop();
            stack1.push(value);
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            Integer value = stack1.pop();
            stack2.push(value);
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue = new TwoStackToQueue();
        twoStackToQueue.push(1);
        twoStackToQueue.push(2);
        twoStackToQueue.push(3);
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
        twoStackToQueue.push(4);
        System.out.println(twoStackToQueue.pop());
        twoStackToQueue.push(5);
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
    }
}
