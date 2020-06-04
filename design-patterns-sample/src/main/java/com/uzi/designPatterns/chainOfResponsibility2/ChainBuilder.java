package com.uzi.designPatterns.chainOfResponsibility2;

/**
 * @Description: 责任链模式与构建者模式结合 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/4
 * ...
 */
public class ChainBuilder {

    public static void main(String[] args) {
        ChainAbs ca = new ChainA();
        ChainAbs cb = new ChainB();
        ChainAbs cc = new ChainC();

        ChainBuilder chainBuilder = new ChainBuilder();
        chainBuilder.next(ca)
                .next(cb)
                .next(cc)
                .doHandler();
    }

    private ChainAbs chainAbsH;
    private ChainAbs chainAbsT;

    public ChainBuilder next(ChainAbs chainAbs){
        if(this.chainAbsH == null){
            this.chainAbsH = this.chainAbsT = chainAbs;
            return this;
        }else{
            this.chainAbsT.next(chainAbs);
            this.chainAbsT = chainAbs;
        }
        return this;
    }

    public void doHandler(){
        chainAbsH.doHandler();
    }
}

// 定义责任链
abstract class ChainAbs{

    ChainAbs chainAbs;

    void next(ChainAbs chainAbs){
        this.chainAbs = chainAbs;
    }

    abstract void doHandler();
}

class ChainA extends ChainAbs{

    @Override
    void doHandler() {
        System.out.println("a");
        chainAbs.doHandler();
    }
}

class ChainB extends ChainAbs{
    @Override
    void doHandler() {
        System.out.println("b");
        chainAbs.doHandler();
    }
}

class ChainC extends ChainAbs{
    @Override
    void doHandler() {
        System.out.println("c");
    }
}