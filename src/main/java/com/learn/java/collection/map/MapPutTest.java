package com.learn.java.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/16
 * @Time:17:41
 */
public class MapPutTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        map.put("aa","a1");
        map.put("aa","a2");
        map.put("bb","b1");
        map.put("bb","b2");
        System.out.println(map);
    }
}
