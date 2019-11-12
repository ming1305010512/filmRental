package com.learn.spring.BeanPostProcessor;

import com.learn.Utils.BeanUtils.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/21
 * @Time:20:17
 */
@Scope
public class Boot {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/learn/BeanPostProcessor/beans.xml");
        User messenger = (User) ctx.getBean("user");
        System.out.println(messenger);
    }

}
