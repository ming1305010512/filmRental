package com.learn.java.enumeration;

import java.util.EnumSet;
import java.util.Set;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/11
 * @Time:15:43
 * @Description 使用Enumset代替位域
 */
public class Text {
    public enum Style{BLOD,ITALIC,UNDERLINE,STRIKETHROUGH}

    public void applyStyles(Set<Style> styles){
        System.out.println(styles);
    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BLOD,Style.ITALIC));
    }
}
