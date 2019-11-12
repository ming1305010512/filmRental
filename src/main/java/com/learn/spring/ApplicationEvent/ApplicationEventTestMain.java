package com.learn.spring.ApplicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/30
 * @Time:19:44
 */
public class ApplicationEventTestMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/learn/ApplicationEvent/beans.xml");
        EmailService emailService = (EmailService) ctx.getBean("emailService");
        emailService.sendEmail("john.doe@example.org","这是join的邮箱");

    }
}
