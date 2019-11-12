package com.learn.spring.baseJavaAnnotation;

import com.learn.Utils.BeanUtils.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/29
 * @Time:20:42
 */
@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId("1");
        user.setUserName("薛美");
        user.setAge("11");
        return user;
    }
}
