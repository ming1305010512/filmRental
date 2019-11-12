package com.learn.spring.ApplicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/30
 * @Time:19:31
 * @Description:自定义事件
 */
public class BlackListEvent extends ApplicationEvent{

    private final String address;
    private final String content;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BlackListEvent(Object source,String address,String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}
