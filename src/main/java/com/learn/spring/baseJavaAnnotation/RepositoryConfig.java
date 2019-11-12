package com.learn.spring.baseJavaAnnotation;

import com.learn.Utils.BeanUtils.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/29
 * @Time:20:45
 */
@Configuration
public class RepositoryConfig {

    private final User user;

    /**
     * 如果目标bean定义了一个构造函数，则不需要指定@Autowired,下面的注解可以去掉
     * @param user
     */
    @Autowired
    public RepositoryConfig(User user) {
        this.user = user;
    }

    @Bean
    public Student student() {
        return new Student(user);
    }
}
