package com.wen.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * Created by 21up on 2020/10/8
 */
public class OrderProducer {
    public static void main(String[] args) throws UnsupportedEncodingException, MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("HAOKE_IM");
        producer.setNamesrvAddr("192.168.88.133:9876");
        producer.start();
        for (int i=0;i<100;i++){
            String msgStr="order -->"+i;
            int orderId=i%10;
            Message message = new Message("haoke_order_topic", "ORDER_MSG", msgStr.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message, (mqs, msg, arg) -> {
                Integer id = (Integer) arg;
                int index = id % mqs.size();
                return mqs.get(index);
            }, orderId);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
