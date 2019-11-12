package com.learn.spring.Validator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.AbstractErrors;
import org.springframework.validation.Errors;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/2/1
 * @Time:10:58
 */
public class ValiatorTestMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/learn/Validator/beans.xml");
        Person person = (Person) ctx.getBean("person");
        PersonValidator personValidator = (PersonValidator) ctx.getBean("personValidator");
        person.setAge(-1);
        person.setName("薛美");
//        Errors errors = AbstractErrors.
//        personValidator.validate(person,errors);
//        System.out.println(errors);
    }
}
