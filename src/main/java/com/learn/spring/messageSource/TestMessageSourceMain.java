package com.learn.spring.messageSource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/30
 * @Time:17:23
 */
public class TestMessageSourceMain {

    public static void main(String[] args) {
        MessageSource messageSource = new ClassPathXmlApplicationContext("config/spring/learn/BeanPostProcessor/beans.xml");
        String message = messageSource.getMessage("message",null,"default",null);
        System.out.println(message);

        String message2 = messageSource.getMessage("argument.required",new Object[]{"userDao"},"Required", Locale.UK);
        System.out.println(message2);
    }
}
