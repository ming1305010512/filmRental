package com.learn.java.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/2
 * @Time:16:35
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();
        listOne.add("1");
        listOne.add("2");
        listOne.add("3");
        List<String> listThree = listOne.stream().limit(listOne.size()).collect(Collectors.toList());
        List<String> listTwo = new ArrayList<>();
        listTwo.add("2");
        listTwo.add("3");
        listOne.removeAll(listTwo);
        System.out.println(listOne);
        System.out.println(listThree);

        /*测试移除元素后对遍历的影响*/
        List<String> listFour = new ArrayList<>();
        listFour.add("1");
        listFour.add("2");
        listFour.add("3");
        listFour.add("4");
        listFour.add("5");
        listFour.add("6");
        for (int i=0;i<listFour.size();i++){
            String a = listFour.get(i);
            System.out.println("索引："+i+",值："+a);
            if (a.equals("2")){
                listFour.remove(i);
                i--;
            }
        }
        System.out.println(listFour);
        /*结论：删除后对应的索引也会降低1，所以索引要减1才能遍历正确*/
    }
}
