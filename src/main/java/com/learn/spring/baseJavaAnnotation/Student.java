package com.learn.spring.baseJavaAnnotation;

import com.learn.Utils.BeanUtils.dto.User;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/29
 * @Time:20:48
 */
public class Student {

    private User user;
    private String studentName;
    private String studentId;
    public Student(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
