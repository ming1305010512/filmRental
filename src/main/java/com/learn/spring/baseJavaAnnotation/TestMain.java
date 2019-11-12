package com.learn.spring.baseJavaAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/29
 * @Time:20:54
 */
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
        // everything wires up across configuration classes...
        People people = ctx.getBean(People.class);
        System.out.println(people);
        System.out.println("haha");

        ApplicationContext ctx2 = new ClassPathXmlApplicationContext("classpath:config/spring/learn/BeanPostProcessor/beans.xml");
        People people2 = ctx2.getBean(People.class);
        System.out.println(people2);
        System.out.println("haha");

        //Spring的环境抽象
        ApplicationContext ctx3 = new GenericApplicationContext();
        Environment environment = ctx3.getEnvironment();
        System.out.println(environment);
    }

}
