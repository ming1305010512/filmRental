package com.learn.java.collection.map;

import com.learn.Utils.BeanUtils.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/5
 * @Time:15:32
 */
public class MapTest {
    private static MapTest ourInstance = new MapTest();

    public static MapTest getInstance() {
        return ourInstance;
    }

    private MapTest() {
    }

    public static void main(String[] args) {
        Map<String,List<User>> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge("1");
        list.add(user);
        User user1 = new User();
        user1.setAge("2");
        list.add(user1);
        map.put("1",list);
        List<User> list2 = new ArrayList<>();
        for (Map.Entry<String,List<User>> entity: map.entrySet()) {
            List<User> list1 = entity.getValue();
            for (User user2: list1) {
                user2.setUserName("3");
            }
            entity.setValue(list1);
            list2.addAll(list);
        }
        System.out.println(list2);

    }
}
