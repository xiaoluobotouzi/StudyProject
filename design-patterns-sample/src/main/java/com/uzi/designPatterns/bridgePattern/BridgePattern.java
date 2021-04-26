package com.uzi.designPatterns.bridgePattern;

/**
 * @ClassName: BridgePattern
 * @Description: 桥接模式 -demo
 * @Author: uziJames
 * @Date 2020/6/1 21:55
 * ...
 */
public class BridgePattern {

    public static void main(String[] args) {
        // 具体实现角色
        Implementor impl = new ConcreteImplementorA();
        // 抽象角色，聚合实现
        Abstraction abst = new RefinedAbstraction(impl);
        // 操作
        abst.operation();
    }

}

// 抽象角色
abstract class Abstraction {

    Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        this.implementor.operationImpl();
    }
}

// 修正抽象角色
class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}

// 实现角色
interface Implementor {
    void operationImpl();
}

// 具体实现角色
class ConcreteImplementorA implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("I`M ConcreteImpl A");
    }
}