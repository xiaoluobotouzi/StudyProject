package com.uzi.designPatterns.observerPattern;

import java.util.ArrayList;

/**
 * @Description: 观察者模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/4
 * ...
 */
public class ObserverPattern {

}

// 目标、主题类
abstract class Subject{

    // 定义一个观察者集合用于存储所有观察者对象
    protected ArrayList<Observer> Observers = new ArrayList<>();

    // 注册方法，往观察者集合增加一个观察者者
    public void addObserver(Observer observer){
        Observers.add(observer);
    }

    // 注销方法，在观察者集合删除一个观察者者
    public void removeObserver(Observer observer){
        Observers.remove(observer);
    }

    // 抽象方法，通知观察者
    public abstract void notifys();
}

// 具体目标类
class ConcreteSubject extends Subject{

    // 实现通知方法
    @Override
    public void notifys() {
        // 遍历观察者集合，调用每一个观察者的响应方法
        for (Object obs : Observers){
            ((Observer) obs).update();
        }
    }
}

// 抽象观察者
interface Observer{
    void update();
}

// 具体观察者
class ConcreteObserver implements Observer{

    @Override
    public void update() {
        System.out.println("做出具体响应");
    }
}


