package com.learn.java.lamba.sorted;

import com.learn.Utils.BeanUtils.dto.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/5/16
 * @Time:15:33
 */
public class SortedTest {

    public static void main(String[] args) throws ParseException {
        List<User> userList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setAge("22");
        user.setBirthday(format.parse("2019-7-3"));
        userList.add(user);
        User user1 = new User();
        user1.setBirthday(format.parse("2019-5-3"));
        user1.setAge("21");
        userList.add(user1);
        User user2 = new User();
        user2.setBirthday(format.parse("2019-6-3"));
        user2.setAge("26");
        userList.add(user2);
        userList.sort((User h1,User h2) ->h1.getBirthday().compareTo(h2.getBirthday()));
        System.out.println(userList);
    }

}
