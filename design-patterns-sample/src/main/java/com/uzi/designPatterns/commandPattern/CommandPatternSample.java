package com.uzi.designPatterns.commandPattern;

/**
 * @Description: 命令模式  -demo
 * @Author: LIU.KL
 * @Date: 2020/6/24
 * ...
 */
public class CommandPatternSample {

    public static void main(String[] args) {

    }
}

// 抽象命令类，只有实现了抽象命令类的具体命令才与请求者关联。最简单的抽象命令类中只包含了一个抽象的execute()方法
interface Command{
    void execute();
}



