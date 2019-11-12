package com.learn.spring.AOP;

import com.learn.Utils.BeanUtils.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/24
 * @Time:15:16
 * @Description:aop后置处理，处理中是对注解的操作
 */
@Aspect
public class AopAspectJ {
//    public static final String EDP="execution(* com.learn.spring.AOP.UserManagerServiceImpl..findUser(..))";
    public static final String EDP="execution(* com.learn.spring.AOP.UserManagerServiceImpl..addUser(..))";
    public static final String EDP2="execution(* com.learn.spring.AOP.UserManagerServiceImpl..findUser(..))";

    @AfterReturning(value=EDP,returning="result")
    public void doAfterReturning(JoinPoint jp, Object result) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("===========执行后置通知============");
        Class aClass = result.getClass();
        String typeName = aClass.getTypeName();
        String className = aClass.getName();
        String canonicalName = aClass.getCanonicalName();
        System.out.println(List.class.isInstance(result));
        if (List.class.isInstance(result)) {
            List list = (List) result;
            for (int i = 0; i < list.size(); i++) {
                Object o = list.get(i);
                Class bclass = o.getClass();
                String bTypeName = bclass.getTypeName();
                String bSimpleName = bclass.getSimpleName();
                Boolean isAnnocation = bclass.isAnnotation();
                Annotation[] annotations = bclass.getAnnotations();
                for (int j = 0; j < annotations.length; j++) {
                    Description description = (Description) annotations[j];
                    String value = description.value();
                    System.out.println(value);
                }
                Field field = bclass.getDeclaredField("userName");
                field.setAccessible(true);
                Object createdByObj = field.get(o);
                System.out.println("33");
            }
        }else {
            Class clazz = result.getClass();
            className = clazz.getName();
        }

    }
    @AfterReturning(value=EDP2,returning="result")
    public void doAfterReturning2(JoinPoint jp, Object result){
        Object[] args = jp.getArgs();
        System.out.println("========================执行后置通知findUser======================");
    }

}
