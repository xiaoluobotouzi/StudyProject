package com.uzi.designPatterns.facadePattern;

/**
 * @Description: 门面模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/26
 * ...
 */
public class FacadePattern {

    public static void main(String[] args) {
        Facade f = new Facade();
        f.doSomethingFacade();
    }
}

class SubSystemA{
    public void methodA(){
        System.out.println("SubSystemA.methodA() executed. ");
    }
}

class SubSystemB{
    public void methodA(){
        System.out.println("SubSystemB.methodA() executed. ");
    }
}

class SubSystemC{
    public void methodA(){
        System.out.println("SubSystemC.methodA() executed. ");
    }
}

class Facade{
    SubSystemA sa = new SubSystemA();
    SubSystemB sb = new SubSystemB();
    SubSystemC sc = new SubSystemC();

    public void doSomethingFacade(){
        sa.methodA();
        sb.methodA();
        sc.methodA();
    }
}