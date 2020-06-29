package com.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Boot项目实现消息消费
 * @Author: LIU.KL
 * ...
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerBootDemo {

    @RequestMapping("/consumerMsg")
    public String consumerMsg(){
        System.out.println("跳转至 ---> com.mq.listener ");
        return "SUCCESS";
    }



    // ==============================================几种消费方式===================================================
    /**
     * 消费指定消息类型String
     * todo 消息类型不可以不指定，不指定的话会出现类型转换异常       RocketMQListener<String>
     */
    @RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic}")
    class consumerMsgListener implements RocketMQListener<String>{
        @Override
        public void onMessage(String message) {
            System.out.println(">>>>>>>>>>>>>>>" + message);
        }
    }

    /**
     * 消费指定类型消息MessageExt
     */
    @RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic}")
    class consumerMsgListener2 implements RocketMQListener<MessageExt>{
        @Override
        public void onMessage(MessageExt msg) {
            System.out.println(msg.getMsgId() + " : " + msg.getKeys() + " : " + new String(msg.getBody()));
        }
    }

    /**
     * 指定消费者从哪开始消费消息，或开始消费的位置。从偏移量开始or时间戳。
     */
    @RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic}", selectorExpression = "TAG_EVENT_ONLINE_ONE_NO")
    class consumerMsgListener3 implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {

        @Override
        public void onMessage(MessageExt msg) {
            System.out.println("指定消费者消费位置：" + msg.getMsgId() + " : " + msg.getKeys() + " : " + new String(msg.getBody()));
        }

        // 指定消费者从哪开始消费消息，或开始消费的位置。从偏移量开始or时间戳。
        @Override
        public void prepareStart(DefaultMQPushConsumer consumer) {
            // set consumer consume message from now
//            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
//            consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
        }
    }

    /**
     * 过滤消息进行消费指定类型消息MessageExt
     * 通过TAGS进行消息过滤     只可以：selectorExpression = "TAG_EVENT_ONLINE_ONE"  不能写成：selectorExpression = "${rocketmq.consumer.tag}"
     * 通过SQL92进行消息过滤    selectorType = SelectorType.SQL92,  selectorExpression = "a = 1"
     *  但是  CODE: 1  DESC: The broker does not support consumer to filter message by SQL92
     */
    @RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic}", selectorExpression = "TAG_DEMO_KL")
    class consumerFilterMsgListener implements RocketMQListener<MessageExt>{
        @Override
        public void onMessage(MessageExt msg) {
            System.out.println("消息过滤：" + msg.getMsgId() + " : " + msg.getKeys() + " : " + new String(msg.getBody()));
        }
    }

}
