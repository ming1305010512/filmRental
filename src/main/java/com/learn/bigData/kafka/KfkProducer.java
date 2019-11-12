package com.learn.bigData.kafka;



import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/11/8
 * @Time:11:13
 * @Description:
 */
public class KfkProducer {

    public static void main(String[] args) {
        String broker = "192.168.227.129:9092,192.168.227.130:9092,192.168.227.131:9092";
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("bootstrap.servers", broker);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        String topic = "myTopic";
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("myTopic", Integer.toString(i), Integer.toString(i)));

        producer.close();

        System.out.println("发送完成");
    }



}
