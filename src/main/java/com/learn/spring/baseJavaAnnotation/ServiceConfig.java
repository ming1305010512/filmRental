package com.learn.spring.baseJavaAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/29
 * @Time:20:45
 */
@Configuration
public class ServiceConfig {

    @Autowired
    private Student student;

    @Bean
    public People people() {
        return new People(student);
    }
}
