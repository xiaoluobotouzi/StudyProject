package com.uzi.designPatterns.FlyweightPattern;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 享元模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/20
 * ...
 */
public class FlyweightPattern {

    public static void main(String[] args) {

        // Integer 中的享元模式   -128到127 使用频繁，使用享元模式
//        Integer i1 = Integer.valueOf(100);
//        Integer i2 = 100;
//
//        Integer i3 = Integer.valueOf(1000);
//        Integer i4 = 1000;
//
//        System.out.println("i1 == i2: " + (i1 == i2)); // true
//        System.out.println("i3 == i4: " + (i3 == i4)); // false

        // 享元模式
        ITicket iTicket = TicketFactory.queryTicket("北京", "天津");
        iTicket.showInfo("二等座");

    }
}

// 场景就是火车票查询：什么座位，从哪里(始发站)，到哪里(终点站)，多少钱

// 定义查询车票的接口
interface ITicket{
    void showInfo(String seat);
}

// 具体的火车票查询实现
class TrainTicket implements ITicket{

    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String seat) {
        this.price = new Random().nextInt(100);
        System.out.println(String.format("%s -> %s  %s  价格 %s 元", this.from, this.to, seat, this.price));
    }
}

// 车票查询工厂
class TicketFactory{
    // 为了线程安全 使用 ConcurrentHashMap
    private static Map<String, ITicket> ticketPool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to){
        String key = from + "TO" + to;
        if(ticketPool.containsKey(key)){
            System.out.print("从缓存中查询：" + key + "，查询结果： ");
            return ticketPool.get(key);
        }
        System.out.print("首次查询：" + key + "，查询结果： ");
        ITicket trainTicket = new TrainTicket(from, to);
        ticketPool.put(key, trainTicket);
        return trainTicket;
    }
}
