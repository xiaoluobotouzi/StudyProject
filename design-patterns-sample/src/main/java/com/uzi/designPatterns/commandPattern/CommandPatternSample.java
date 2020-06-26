package com.uzi.designPatterns.commandPattern;

import java.util.*;

/**
 * @Description: 命令模式  -demo
 * @Author: LIU.KL
 * @Date: 2020/6/24
 * ...
 */
public class CommandPatternSample {

    public static void main(String[] args) {

        // 使用一种策略来维护命令集合
        Map<String, Invoker> maps = new HashMap<>();
        maps.put("w", new Invoker(new MoveForwardConcreteCommand(new MoveForwardReceiver())));
        maps.put("s", new Invoker(new MoveBackOffConcreteCommand(new MoveBackOffReceiver())));
        maps.put("a", new Invoker(new MoveLeftCommandConcreteCommand(new MoveLeftReceiver())));
        maps.put("d", new Invoker(new MoveRightCommandConcreteCommand(new MoveRightReceiver())));

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String command = scan.nextLine();
//            System.out.println(command);
            if(maps.containsKey(command)){
                maps.get(command).call();
            }
        }
        scan.close();

    }
}

/**
 * 场景：游戏里的人物进行移动，发出命令，人物做出相应的动作（w前进s后退a左移d右移）
 * 人物攻击同样是发出命令，人物做出响应的动作（q狱血魔神e噬魂r大闹天宫） 【请自行实现呦】
 */

// 抽象命令类,只有实现了抽象命令类的具体命令才与请求者关联。最简单的抽象命令类中只包含了一个抽象的execute()方法
interface Command{
    void execute();
}

// 具体命令类
class MoveForwardConcreteCommand implements Command {

    private MoveForwardReceiver moveForwardReceiver;

    public MoveForwardConcreteCommand(MoveForwardReceiver moveForwardReceiver){
        this.moveForwardReceiver = moveForwardReceiver;
    }

    @Override
    public void execute() {
        moveForwardReceiver.forward();
    }
}

class MoveBackOffConcreteCommand implements Command {

    private MoveBackOffReceiver moveBackOffReceiver;

    public MoveBackOffConcreteCommand(MoveBackOffReceiver moveBackOffReceiver){
        this.moveBackOffReceiver = moveBackOffReceiver;
    }

    @Override
    public void execute() {
        moveBackOffReceiver.backoff();
    }
}

class MoveLeftCommandConcreteCommand implements Command{

    private MoveLeftReceiver moveLeftReceiver;

    public MoveLeftCommandConcreteCommand(MoveLeftReceiver moveLeftReceiver){
        this.moveLeftReceiver = moveLeftReceiver;
    }

    @Override
    public void execute() {
        moveLeftReceiver.left();
    }
}

class MoveRightCommandConcreteCommand implements Command{

    private MoveRightReceiver moveRightReceiver;

    public MoveRightCommandConcreteCommand(MoveRightReceiver moveRightReceiver){
        this.moveRightReceiver = moveRightReceiver;
    }

    @Override
    public void execute() {
        moveRightReceiver.right();
    }
}

// 请求的接收者，也就是具体的命令实现
class MoveForwardReceiver{
    public void forward(){
        System.out.println("前进");
    }
}
class MoveBackOffReceiver{
    public void backoff(){
        System.out.println("后退");
    }
}
class MoveLeftReceiver{
    public void left(){
        System.out.println("左移");
    }
}
class MoveRightReceiver{
    public void right(){
        System.out.println("右移");
    }
}

// 请求发送者
class Invoker{

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void call(){
        command.execute();
    }
}