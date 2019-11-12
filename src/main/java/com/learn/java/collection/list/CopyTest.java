package com.learn.java.collection.list;

import com.learn.Utils.BeanUtils.dto.User;
import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/23
 * @Time:16:56
 * @Description: 使用序列化实现集合深复制
 */
public class CopyTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setUserName("a1");
        List<User> list1 = new ArrayList<>();
        list1.add(user);
        List<User> list2 = new ArrayList<>();
       list2 = deepCopy(list1);
        list1.get(0).setUserName("a2");
        System.out.println("");
    }

    public static  List<User> deepCopy(List<User> src) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<User> dest = (List<User>) in.readObject();
        return dest;
    }
}
