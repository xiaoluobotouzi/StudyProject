package com.uzi.designPatterns.chainOfResponPattern;

/**
 * @ClassName: ChainOfResponsibilityPattern
 * @Description: 责任链模式 -demo
 * @Author: uziJamesi
 * @Date 2020/6/2 21:26
 * ...
 */
public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        Handler handlerA, handlerB;
        handlerA = new ConcreteHandlerA();
        handlerB = new ConcreteHandlerB();
        handlerA.setHandler(handlerB);
        handlerA.handlerRequest("A");
    }
}

abstract class Handler{

    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    abstract void handlerRequest(String request);
}

class ConcreteHandlerA extends Handler{
    @Override
    void handlerRequest(String request) {
        if("A".equals(request)){
            // 处理请求
            System.out.println(request);
        }
        // 处理完转发
        this.handler.handlerRequest(request);
    }
}

class ConcreteHandlerB extends Handler{
    @Override
    void handlerRequest(String request) {
        if("B".equals(request)){
            // 处理请求
        }
        // 处理完转发
        this.handler.handlerRequest(request);
    }
}