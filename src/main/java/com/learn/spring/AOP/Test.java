package com.learn.spring.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/24
 * @Time:15:18
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext act =  new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        IUserManagerService userManager = (IUserManagerService)act.getBean("userManager");
        userManager.findUser("薛美","21");
        System.out.println("\n");
        userManager.addUser("薛美","11");
    }

}
