package com.wen.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * Created by 21up on 2020/10/8
 * 异步发送消息
 */
public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("HAOKE_IM");
        producer.setNamesrvAddr("192.168.88.133:9876");
        // 发送失败的重试次数
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.start();
        String msgStr = "用户A发送消息给用户B";
        Message msg = new Message("haoke_im_topic", "SEND_MSG_ASY", msgStr.getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 异步发送消息
        producer.send(msg, new SendCallback() {
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息状态：" + sendResult.getSendStatus());
                System.out.println("消息id：" + sendResult.getMsgId());
                System.out.println("消息queue：" + sendResult.getMessageQueue());
                System.out.println("消息offset：" + sendResult.getQueueOffset());
            }

            public void onException(Throwable e) {
                System.out.println("发送失败！" + e);
            }
        });
        System.out.println("发送成功！");
    }
}
