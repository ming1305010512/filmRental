package com.learn.spring.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/2/1
 * @Time:10:53
 */
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Person person = (Person)target;
        if (person.getAge()<0){
            errors.rejectValue("age","negativevalue");
        }else if (person.getAge()>110){
            errors.rejectValue("age","too.darn.old");
        }
    }
}
