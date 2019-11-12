package com.learn.spring.ApplicationEvent;

import org.springframework.context.ApplicationListener;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/30
 * @Time:19:39
 * @Description:自定义监听器
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent>{

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        String address = event.getAddress();
        String content = event.getContent();
        System.out.println("我收到了"+address+"这个地址的邮件，内容为："+content);
    }
}
