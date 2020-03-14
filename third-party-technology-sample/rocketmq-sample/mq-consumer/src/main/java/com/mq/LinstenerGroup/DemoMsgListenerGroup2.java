package com.mq.LinstenerGroup;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.LoggerFactory;

/**
 * @Description: 消费者监听消息进行消费
 * @Author: LIU.KL
 * ...
 */
//@Service
//@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic2}")
public class DemoMsgListenerGroup2 implements RocketMQListener<MessageExt> {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(MessageExt msg) {
        try {
            logger.info("RECEIVE_MSG_BEGIN: " + msg.toString());
            System.out.println(String.format("GROUP--消费消息，消息ID：%s，消息KEY：%s，消息体：%s ", msg.getMsgId(), msg.getKeys(), new String(msg.getBody())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: 2019/6/27 避免LinstenerGroup 下的这种写法  同一个消费组 不同TOPIC

}
