package com.mq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @Description: 原生java项目实现消息生产者
 * @Author: LIU.KL
 * ...
 */
public class ProducerJavaDemo {

    public static void main(String[] args) {

        syncSendMsg("Hello world 20190618-1");

    }

    /**
     * 同步发送消息到MQ
     */
    public static void syncSendMsg(String msg){
        // 实例化消息生产者，唯一生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("PG_DEMO_KL");
        // 设置NameServer的地址，多个nameServer就使用英文分号隔开
        producer.setNamesrvAddr("10.10.16.20:9876;10.10.16.41:9876;");
        try {
            // 启动Producer实例
            producer.start();

            // 消息失败重投次数，默认2，但会执行2+1次，retryTimesWhenSendFailed
            producer.setRetryTimesWhenSendFailed(2);

            // 创建消息，并指定Topic，Tag，msgKey和消息体
            Message message = new Message("TOPIC_DEMO_KL", "TAG_DEMO_KL", "001", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

            // 发送消息到一个Broker
            SendResult sendResult = producer.send(message);

            // 通过sendResult返回消息是否成功送达
            System.out.println("msgId:" + sendResult.getMsgId() + " result:" + sendResult.getSendStatus());

            // 设置消息发送超时时间
//            SendResult sendResult1 = producer.send(message,3000);

            // 设置消息发送成功或发送失败之后的回调
//            producer.send(message, new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    System.out.println("发送成功执行...");
//                }
//
//                @Override
//                public void onException(Throwable e) {
//                    System.out.println("发送失败执行...");
//                }
//            });

            // 设置消息发送成功或发送失败之后的回调,和超时时间
//            producer.send(message, new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    System.out.println("发送成功执行...");
//                }
//
//                @Override
//                public void onException(Throwable e) {
//                    System.out.println("发送失败执行...");
//                }
//            }, 3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 如果不再发送消息，关闭Producer实例
            producer.shutdown();
        }
    }

    /**
     * 发送异步消息到MQ
     */
    public static void asyncSendMsg(){

        // 实例化消息生产者Producer，唯一生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("PG_DEMO_KL");
        // 设置NameServer的地址
        producer.setNamesrvAddr("10.10.16.20:9876");
        try {
            // 启动Producer实例
            producer.start();
            // 异步发送失败，在内部执行的重试次数。可能会导致消息重复，需要开发人员来控制。
            producer.setRetryTimesWhenSendAsyncFailed(0);

            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("TOPIC_DEMO_KL", "TAG_DEMO_KL","001", "Hello World".getBytes());

            // 发送消息到一个Broker
            producer.send(msg, new SendCallback() {
                // 异步发送成功回调
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", sendResult.getMsgId());
                }
                // 异步发送失败回调
                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 如果不再发送消息，关闭Producer实例
            producer.shutdown();
        }
    }

}