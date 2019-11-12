package com.learn.spring.AOP;

import com.learn.Utils.BeanUtils.dto.User;

import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/24
 * @Time:14:16
 */
public interface  IUserManagerService {
    /**
     * 查找用户
     * @return
     */
    public List<User> findUser(String name,String age);

    /**
     * 添加用户
     */
    public User addUser(String name,String age);
}
