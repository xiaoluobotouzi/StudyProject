package com.uzi.designPatterns.delegatePattern;

/**
 * @ClassName: DelegatePatternSample
 * @Description: 委派模式 sample
 * @Author: uziJamesi
 * @Date 2020/6/18 22:45
 * ...
 */
public class DelegatePatternSample {
    public static void main(String[] args) {
        Delegate delegateA = new Delegate("a");
        delegateA.doTask();
        Delegate delegateB = new Delegate("b");
        delegateB.doTask();
        Delegate delegateC = new Delegate("c");
        delegateC.doTask();
    }
}

// 抽象任务角色
interface Task{
    void doTask();
}

// 具体任务角色
class ConcreteTaskA implements Task{

    @Override
    public void doTask() {
        System.out.println("A来实现这个具体任务");
    }
}
class ConcreteTaskB implements Task{

    @Override
    public void doTask() {
        System.out.println("B来实现这个具体任务");
    }
}

// 委派者角色
class Delegate implements Task{

    private String task;

    public Delegate(String task){
        this.task = task;
    }

    // 在各个具体角色实例中做出决策，判断并正确调用具体实现的方法
    @Override
    public void doTask() {
        if("a".equals(task)){
            System.out.print("这个工作A擅长  ");
            new ConcreteTaskA().doTask();
        }else if("b".equals(task)){
            System.out.print("这个工作B擅长  ");
            new ConcreteTaskB().doTask();
        }else{
            System.out.println("这个工作没人会...");
        }
    }
}