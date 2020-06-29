package com.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @Description: 原生Java项目实现消息消费者
 * @Author: LIU.KL
 * ...
 */
public class ConsumerJavaDemo {

    public static void main(String[] args){
        consumerMsg();
    }

    /**
     * 消费者消费消息
     */
    public static void consumerMsg(){
        try {
            // 实例化消息消费者consumer，指定消费组
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CG_DEMO_KL");
            // 设置NameServer的地址，多个nameServer地址英文分号分开
            consumer.setNamesrvAddr("127.0.0.1:9876");
            // 消费失败重试次数  默认-1 = 16次。
            consumer.setMaxReconsumeTimes(3);
            // 订阅一个Topic，多个Tag来消费消息，多个tag这样写：TagA || TagB || TagC
            consumer.subscribe("TOPIC_DEMO_KL", "*");
            // 注册回调实现类来处理从broker拉取回来的消息
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    System.out.println(Thread.currentThread().getName());
                    if(null != msgs){
                        for (MessageExt msg : msgs) {
                            System.out.println("MsgID：" + msg.getMsgId() + "  Topic：" + msg.getTopic() + "  MsgBody：" + new String(msg.getBody()));
                        }
                    }else{
                        System.out.println("msgs is null");
                    }
                    // 标记该消息已经被成功消费
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            // 启动消费者实例
            consumer.start();
            System.out.printf("Consumer Started.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
