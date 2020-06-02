package com.uzi.designPatterns.strategyPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 策略模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/2
 * ...
 */
public class StrategyPattern {

    public static void main(String[] args) {

        vipDiscount vipDiscount = new vipDiscount();
        double v1 = vipDiscount.getPrice("V1", 138);
        System.out.println("VIP 1 优惠价：" + v1);

        Context context = new Context();
        double v1Price = context.getPrice("V1", 138);
        System.out.println("VIP 1 优惠价：" + v1Price);
    }

}

// 生活场景：不同VIP等级的折扣不同
// 依照这个场景，写出来的代码可能会像这个样子
class vipDiscount{
    public double getPrice(String vipLevel, double price){
        if("V1".equals(vipLevel)){
            return price * 0.98;
        }else if("V2".equals(vipLevel)){
            return price * 0.93;
        }else if("V3".equals(vipLevel)){
            return price * 0.88;
        }
        return price;
    }
}

// 使用策略模式重构代码，消除if...else...
// 定义抽象策略算法类
abstract class AbstractStrategy{
    abstract double algorithm(double price);
}

// 定义每一种算法的类，作为抽象策略类的子类
class V1ConcreteStrategy extends AbstractStrategy {

    @Override
    double algorithm(double price) {
        return price * 0.98;
    }
}
class V2ConcreteStrategy extends AbstractStrategy {

    @Override
    double algorithm(double price) {
        return price * 0.93;
    }
}
class V3ConcreteStrategy extends AbstractStrategy {

    @Override
    double algorithm(double price) {
        return price * 0.88;
    }
}

// 定义上下文角色，负责和具体的策略类交互
class Context{
//    AbstractStrategy strategy;
//
//    public Context(AbstractStrategy strategy) {
//        this.strategy = strategy;
//    }
//
//    public double getPrice(double price){
//        return strategy.algorithm(price);
//    }

    // 定义一个算法族，将算法策略封装
    static Map<String, AbstractStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("V1", new V1ConcreteStrategy());
        strategyMap.put("V2", new V2ConcreteStrategy());
        strategyMap.put("V3", new V3ConcreteStrategy());
    }

    public double getPrice(String vipLevel, double price){
        if(strategyMap.containsKey(vipLevel)){
            return strategyMap.get(vipLevel).algorithm(price);
        }
        return price;
    }
}
