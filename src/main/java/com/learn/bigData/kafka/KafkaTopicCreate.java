package com.learn.bigData.kafka;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.Producer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/11/7
 * @Time:22:01
 * @Description:
 */
public class KafkaTopicCreate {

    private static Log logger = LogFactory.getLog(KafkaTopicCreate.class);
    private static final String broker = "192.168.227.129:9092,192.168.227.130:9092,192.168.227.131:9092";

    public static Producer<String,String> producer;
    public static AdminClient client;

    /**
     * 用于开始的属性初始化(客户端初始化)
     */
    public static void beforeClass(){
        Properties properties = new Properties();
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,broker);
        client = AdminClient.create(properties);
    }

    /**
     * 用于关闭client
     */
    public static void afterClass(){
        client.close();
    }

    /**
     * 创建主题
     * @param topic
     */
    public static void createTopics(String topic){
        NewTopic newTopic = new NewTopic(topic,3,(short) 2);
        Collection<NewTopic> newTopics = new ArrayList<>();
        newTopics.add(newTopic);
        //创建主题
        CreateTopicsResult result = client.createTopics(newTopics);
        try {
            result.all().get();
            System.out.println("Topic创建成功！");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("创建失败："+e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        beforeClass();
        createTopics("myTopic");
    }


}
