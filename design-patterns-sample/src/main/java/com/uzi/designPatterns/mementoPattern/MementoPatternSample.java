package com.uzi.designPatterns.mementoPattern;

import java.util.Stack;

/**
 * @Description: 备忘录模式  -demo
 * @Author: LIU.KL
 * @Date: 2020/6/30
 * ...
 */
public class MementoPatternSample {
    public static void main(String[] args) {
        // 声明备忘录管理员
        Caretaker caretaker = new Caretaker();

        // 发起人
        Originator originator = new Originator();
        originator.setStr("a");

        // 开始备忘
        Memento memento = originator.saveToMemento();
        caretaker.addMemento(memento);
        System.out.println("1当前对象完整信息：" + originator);

        originator.setStr("ab");
        memento = originator.saveToMemento();
        caretaker.addMemento(memento);
        System.out.println("2当前对象完整信息：" + originator);

        originator.setStr("abc");
        memento = originator.saveToMemento();
        caretaker.addMemento(memento);
        System.out.println("3当前对象完整信息：" + originator);

        originator.setStr("abc123");
        originator.saveToMemento();
        System.out.println("4当前对象完整信息：" + originator);

        memento = caretaker.getMemento();
        originator.undoLastTime(memento);
        System.out.println("撤销1次之后完整信息：" + originator);

        memento = caretaker.getMemento();
        originator.undoLastTime(memento);
        System.out.println("撤销2次之后完整信息：" + originator);



    }
}

// 发起人角色，需要被回滚的对象
class Originator{

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Memento saveToMemento(){
        Memento memento = new Memento(this.str);
        return memento;
    }

    public void undoLastTime(Memento memento){
        this.str = memento.getStr();
    }

    @Override
    public String toString() {
        return "Originator{" +
                "str='" + str + '\'' +
                '}';
    }
}

// 备忘录角色
class Memento{

    private String str;

    public String getStr() {
        return str;
    }

    public Memento(String str){
        this.str = str;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "str='" + str + '\'' +
                '}';
    }
}

// 备忘录管理角色，记录每一个版本
class Caretaker{

    // 利用栈的一个 后进先出 特性
    private Stack<Memento> mementoStack = new Stack<>();

    public Memento getMemento(){
        return mementoStack.pop();
    }

    public void addMemento(Memento memento){
        mementoStack.push(memento);
    }
}