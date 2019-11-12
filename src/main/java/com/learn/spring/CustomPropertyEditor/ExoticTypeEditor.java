package com.learn.spring.CustomPropertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/2/14
 * @Time:11:12
 */
public class ExoticTypeEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        setValue(new ExoticType(text.toUpperCase()));
    }
}
