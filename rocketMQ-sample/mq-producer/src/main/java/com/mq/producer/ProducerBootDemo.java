package com.mq.producer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: boot项目实现消息生产者
 * @Author: LIU.KL
 * ...
 */
@RestController
@RequestMapping("/producer")
public class ProducerBootDemo {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value(value = "${rocketmq.producer.topic}")
    private String topic;
    @Value(value = "${rocketmq.producer.tag}")
    private String tag;


    /**
     * 同步发送消息到MQ
     */
    @RequestMapping("/syncSendMsg2MQ")
    public String syncSendMsg2MQ(String keys){
        // 发送的消息.消息体必须存在
        String msg = "Hello World " + keys;
        // 业务主键作为消息key
        String key = keys;
        // 发送目的地  TOPIC:TAG
        String destination = topic + ":" + tag;
        // 构建消息
        Message message = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.KEYS, key)
                .build();
        SendResult sendResult = rocketMQTemplate.syncSend(destination, message);
        if(sendResult.getSendStatus() == SendStatus.SEND_OK){
            System.out.println(sendResult.getMsgId() + " : " + sendResult.getSendStatus());
        }
        return LocalDateTime.now() +" 》》SUCCESS 》》 "  + sendResult.getMsgId() + " : " + sendResult.getSendStatus();
    }

    /**
     * 同步批量发送消息到MQ
     */
    @RequestMapping("/syncSendMsg2MQBatch")
    public String syncSendMsg2MQBatch(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Thread myThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 发送目的地  TOPIC:TAG
                        String destination = topic + ":" +
                                 tag;
                        for (int i = 0; i < 10000; i++) {
                            // 发送的消息.消息体必须存在
                            String msg = "Hello World " + i + " 》" + LocalDateTime.now();
                            // 业务主键作为消息key
                            String key = i+"";
                            // 构建消息
                            Message message = MessageBuilder.withPayload(msg)
                                    .setHeader(RocketMQHeaders.KEYS, key)
                                    .build();
                            SendResult sendResult = rocketMQTemplate.syncSend(destination, message);
                            if(sendResult.getSendStatus() == SendStatus.SEND_OK){
                                System.out.println(sendResult.getMsgId() + " : " + sendResult.getSendStatus());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            executorService.execute(myThread);
        }
        return " 》》Send Msg Success 》》";
    }

    /**
     * 批量发送消息到MQ
     */
    @RequestMapping("/syncSendMsgList2MQ")
    public String syncSendMsgList2MQ(){
        List<Message<?>> messageList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Message message = MessageBuilder.withPayload("Hello World " + i + " " + LocalDateTime.now())
                    .setHeader(RocketMQHeaders.KEYS,"000000-" + i)
                    .build();
            messageList.add(message);
        }
        // 发送目的地  TOPIC:TAG
        String destination = topic + ":" + tag;
        SendResult sendResult = rocketMQTemplate.syncSend(destination, messageList, 6000);
        if(sendResult.getSendStatus() == SendStatus.SEND_OK){
            System.out.println(sendResult.getMsgId() + " : " + sendResult.getSendStatus());
        }
        return LocalDateTime.now() +" 》》SUCCESS 》》 "  + sendResult.getMsgId() + " : " + sendResult.getSendStatus();
    }

}
