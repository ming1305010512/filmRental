package com.learn.spring.AOP;

import com.learn.Utils.BeanUtils.dto.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/24
 * @Time:15:06
 */
public class UserManagerServiceImpl implements IUserManagerService {

    private String name;
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public List<User> findUser(String name,String age) {
        User user = new User();
        user.setAge(age);
        user.setId("1");
        user.setUserName(name);
        List<User> users = new ArrayList<>();
        users.add(user);
        System.out.println("============执行业务方法findUser,查找的用户是："+name+"=============");
        return users;
    }

    @Override
    public User addUser(String name,String age) {
        User user = new User();
        user.setAge(age);
        user.setId("1");
        user.setUserName(name);
        System.out.println("============执行业务方法addUser=============");
        return user;
    }
}
