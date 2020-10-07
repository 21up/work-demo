package com.wen.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * Created by 21up on 2020/9/28
 */
public class TopicDemo {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("haoke");
        producer.setNamesrvAddr("192.168.88.133:9876");
        producer.start();
        producer.createTopic("broker_haoke_im","haoke_im_topic",8);
        System.out.println("创建topic成功");
        //producer.shutdown();
    }
}
