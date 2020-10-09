package com.wen.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created by 21up on 2020/10/9
 */
public class OrderConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("HAOKE_ORDER_CONSUMER");
        consumer.setNamesrvAddr("192.168.88.133:9876");
        consumer.subscribe("haoke_order_topic","*");
        consumer.registerMessageListener((MessageListenerOrderly) (list, context)->{
            System.out.println(Thread.currentThread().getName()+"receive new message"+list);
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
    }
}
