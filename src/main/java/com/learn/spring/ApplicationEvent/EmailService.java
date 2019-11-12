package com.learn.spring.ApplicationEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/1/30
 * @Time:19:35
 * @Description:发布事件的服务类
 */
public class EmailService implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher publisher;
    private List<String> blackList;

    public void setBlackList(List<String> blackList){
        this.blackList = blackList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address,String content){
        if (blackList.contains(address)) {
            publisher.publishEvent(new BlackListEvent(this, address, content));
            return;
        }
        //send email...
    }
}
