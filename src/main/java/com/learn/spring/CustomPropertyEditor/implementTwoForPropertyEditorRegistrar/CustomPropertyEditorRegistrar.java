package com.learn.spring.CustomPropertyEditor.implementTwoForPropertyEditorRegistrar;

import com.learn.spring.CustomPropertyEditor.ExoticType;
import com.learn.spring.CustomPropertyEditor.ExoticTypeEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/2/14
 * @Time:11:23
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // it is expected that new PropertyEditor instances are created
        registry.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());

        // you could register as many custom property editors as are required here...

    }
}
