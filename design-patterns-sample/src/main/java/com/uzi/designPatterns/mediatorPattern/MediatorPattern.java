package com.uzi.designPatterns.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 中介者模式  -demo
 * @Author: LIU.KL
 * @Date: 2020/6/28
 * ...
 */
public class MediatorPattern {

    public static void main(String[] args) {

        // 初始化中介者
        Mediator mediator = new ConcreteMediator();

        // 具体同事类，交互的对象
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();

        // 中介者维护具体同事类
        mediator.register(c1);
        mediator.register(c2);

        // 某同事类发出请求
        c2.send();

    }
}

// 抽象中介者
interface Mediator{

    void register(Colleague colleague);

    void relay(Colleague colleague);

}

// 具体抽象者
class ConcreteMediator implements Mediator{

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setColleague(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague colleague1 : colleagues) {
            if(!colleague1.equals(colleague)){
                colleague1.receive();
            }
        }
    }
}

abstract class Colleague{

    protected Mediator mediator;

    public void setColleague(Mediator mediator){
        this.mediator = mediator;
    }

    abstract void receive();
    abstract void send();

}

class ConcreteColleague1 extends Colleague {

    @Override
    void receive() {
        System.out.println("ConcreteColleague1 收到请求");
    }

    @Override
    void send() {
        System.out.println("ConcreteColleague1 发出请求");
        mediator.relay(this); // 中介者转发请求
    }
}

class ConcreteColleague2 extends Colleague {

    @Override
    void receive() {
        System.out.println("ConcreteColleague2 收到请求");
    }

    @Override
    void send() {
        System.out.println("ConcreteColleague2 发出请求");
        mediator.relay(this); // 中介者转发请求
    }
}