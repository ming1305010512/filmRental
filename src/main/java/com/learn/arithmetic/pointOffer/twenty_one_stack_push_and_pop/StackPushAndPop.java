package com.learn.arithmetic.pointOffer.twenty_one_stack_push_and_pop;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/24
 * @Time: 15:18
 * @Description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 示例1
 * 输入：
 *
 * [1,2,3,4,5],[4,3,5,1,2]
 *
 * 返回值：
 *
 * false
 */
public class StackPushAndPop {

    /**
     * 使用一个辅助栈来模拟，看是否能模拟成功
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        MyStack stack = new MyStack();
        for (int i=0,j=0;i<pushA.length&&j<popA.length;){
            int value = pushA[i];
            if (value!=popA[j]){
                stack.push(value);
                i++;
            }else {
                j++;
                while (!stack.isEmpty()&&stack.peek()==popA[j]){
                    stack.pop();
                    j++;
                }
                i++;
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        StackPushAndPop stackPushAndPop = new StackPushAndPop();
        int [] pushA = new int[]{1,2,3,4,5};
        int [] popB = new int[]{4,3,5,2,1};
        System.out.println(stackPushAndPop.IsPopOrder(pushA,popB));
    }
}

class MyStack{
    ArrayList<Integer> stack = new ArrayList<>();
    public void push(int value){
        stack.add(value);
    }
    public int pop(){
        int value = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return value;
    }
    public int peek(){
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty(){
        if (stack.size()==0){
            return true;
        }else {
            return false;
        }
    }
}
