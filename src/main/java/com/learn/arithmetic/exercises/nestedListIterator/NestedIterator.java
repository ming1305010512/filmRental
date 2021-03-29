package com.learn.arithmetic.exercises.nestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> integerList = new ArrayList<>();
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        handle(nestedList);
    }

    @Override
    public Integer next() {
        return integerList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < integerList.size();
    }

    public void handle(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList){
            if (nestedInteger.isInteger()){
                integerList.add(nestedInteger.getInteger());
            }else {
                List<NestedInteger> list = nestedInteger.getList();
                handle(list);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

interface NestedInteger{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

class MyNestedIntegerData implements NestedInteger{

    private List<Integer> list;

    public MyNestedIntegerData(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        if (list.size()==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Integer getInteger() {
        return list.get(0);
    }

    @Override
    public List<NestedInteger> getList() {
        List nestedIntegers = new ArrayList();
        for (Integer integer : list){
            List list = new ArrayList();
            list.add(integer);
            MyNestedIntegerData nestedIntegerData = new MyNestedIntegerData(list);
            nestedIntegers.add(nestedIntegerData);
        }
        return nestedIntegers;
    }
}

class TestClass{
    public static void main(String[] args) {

        /**
         * 下面所造数据格式为[1,[2,3],4,[5,[6,7]]]
         */
        List<List<NestedInteger>> nestedIntegers = new ArrayList<>();

        List<NestedInteger> nestedIntegers1 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        MyNestedIntegerData nestedIntegerData1 = new MyNestedIntegerData(list1);
        nestedIntegers1.add(nestedIntegerData1);

        List<NestedInteger> nestedIntegers2 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        MyNestedIntegerData nestedIntegerData2 = new MyNestedIntegerData(list2);
        nestedIntegers2.add(nestedIntegerData2);

        List<NestedInteger> nestedIntegers3 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        MyNestedIntegerData nestedIntegerData3 = new MyNestedIntegerData(list3);
        nestedIntegers3.add(nestedIntegerData3);

        List<NestedInteger> nestedIntegers4 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list4.add(5);
        MyNestedIntegerData nestedIntegerData4 = new MyNestedIntegerData(list4);
        nestedIntegers4.add(nestedIntegerData4);

        List<Integer> list5 = new ArrayList<>();
        list5.add(6);
        list5.add(7);
        MyNestedIntegerData nestedIntegerData5 = new MyNestedIntegerData(list5);
        nestedIntegers4.add(nestedIntegerData5);

        nestedIntegers.add(nestedIntegers1);
        nestedIntegers.add(nestedIntegers2);
        nestedIntegers.add(nestedIntegers3);
        nestedIntegers.add(nestedIntegers4);


        for (List<NestedInteger> list : nestedIntegers){
            NestedIterator i = new NestedIterator(list);
            while (i.hasNext()){
                System.out.println(i.next());
            }
        }
    }
}

