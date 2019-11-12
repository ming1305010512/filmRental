package com.learn.spring.CustomPropertyEditor;

import com.learn.spring.ApplicationEvent.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/2/14
 * @Time:11:15
 */
public class PropertyEditorTestMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/learn/CustomPropertyEditor/beans.xml");
        DependsOnExoticType dependsOnExoticType = (DependsOnExoticType) ctx.getBean("sample");
        System.out.println(dependsOnExoticType);

    }
}
