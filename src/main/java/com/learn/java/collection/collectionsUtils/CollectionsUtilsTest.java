package com.learn.java.collection.collectionsUtils;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/7/18
 * @Time:15:18
 */
public class CollectionsUtilsTest {

    public static void main(String[] args) {
        String a = null;
        List<String> strs = new ArrayList<>();
        strs.add(a);
        System.out.println(CollectionUtils.isNotEmpty(strs));
    }
}
