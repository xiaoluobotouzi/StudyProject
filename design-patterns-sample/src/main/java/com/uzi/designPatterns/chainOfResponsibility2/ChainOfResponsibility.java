package com.uzi.designPatterns.chainOfResponsibility2;

/**
 * @Description: 责任链模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/3
 * ...
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        Handler ha = new ConcreteHandlerA();
        Handler hb = new ConcreteHandlerB();
        Handler hc = new ConcreteHandlerC();

        // 将定义好的 handler 根据业务串联起来 形成一条链  a-->b-->c
        // 例如审批流程的：组长-->经理-->总监-->CEO
        ha.next(hb);
        hb.next(hc);

        ha.doHandler("ABC");

    }

}

abstract class Handler{
    Handler handler;

    public void next(Handler handler) {
        this.handler = handler;
    }

    abstract void doHandler(String request);
}

class ConcreteHandlerA extends Handler{
    @Override
    void doHandler(String request) {
        if(request.contains("A")){
            if(request.indexOf("A") > 0){
                System.out.println("请以A为开始点");
                return;
            }
            System.out.println("包含A，处理完成");
        }else{
            System.out.println("A为必传");
            return;
        }
        handler.doHandler(request);
    }
}

class ConcreteHandlerB extends Handler{
    @Override
    void doHandler(String request) {
        if(request.contains("B")){
            System.out.println("包含B，处理完成");
        }
        handler.doHandler(request);
    }
}

class ConcreteHandlerC extends Handler{
    @Override
    void doHandler(String request) {
        if(request.contains("C")){
            System.out.println("包含C，处理完成");
        }
        // c为最后一个处理对象，不需要设置下一个点
    }
}