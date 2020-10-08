package com.wen.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.security.ProtectionDomain;

/**
 * Created by 21up on 2020/10/7
 * 同步发送消息
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("HAOKE_IM");
        producer.setNamesrvAddr("192.168.88.133:9876");
        producer.start();
        String msgStr = "用户a发消息给用户b";
        Message message = new Message("haoke_im_topic", "SEND_MSG", msgStr.getBytes(RemotingHelper.DEFAULT_CHARSET));
        //发送消息
        SendResult sendResult = producer.send(message);
        System.out.println("消息状态："+sendResult.getSendStatus());
        System.out.println("消息id："+sendResult.getMsgId());
        System.out.println("消息queue："+sendResult.getMessageQueue());
        System.out.println("消息offset："+sendResult.getQueueOffset());
        producer.shutdown();
    }
}
