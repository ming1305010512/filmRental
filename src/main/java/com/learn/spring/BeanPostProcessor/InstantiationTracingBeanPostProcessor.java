package com.learn.spring.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/21
 * @Time:19:46
 * @Descript:自定义BeanPostProcessor实现类
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor{

    /**
     * simply return the instantiated bean as-is
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // we could potentially return any object reference here...
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}
