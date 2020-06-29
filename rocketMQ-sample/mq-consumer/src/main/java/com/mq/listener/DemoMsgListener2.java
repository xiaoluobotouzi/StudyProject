package com.mq.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description: 消费者监听消息进行消费
 * @Author: LIU.KL
 * ...
 */
@Service
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group2}", topic = "${rocketmq.consumer.topic}", consumeThreadMax = 32)
public class DemoMsgListener2 implements RocketMQListener<MessageExt> {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(MessageExt msg) {
        logger.info("RECEIVE_MSG_BEGIN: " + msg.toString());
        logger.info(String.format("消费者消费消息，消息ID：%s，消息KEY：%s，消息体：%s ", msg.getMsgId(), msg.getKeys(), new String(msg.getBody())));
    }

}
