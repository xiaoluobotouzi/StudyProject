package com.uzi.designPatterns.statePattern;

/**
 * @Description: 状态模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/30
 * ...
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();

        StartState start = new StartState();
        start.doSome(context);

        StopState stop = new StopState();
        stop.doSome(context);

    }
}

// 上下文角色
class Context{
    private State state;

    public void setState(State state) {
        this.state = state;
    }

}

// 抽象状态角色
interface State{
    // 抽象业务方法，不同的具体状态类可以不同的实现
    void doSome(Context context);
}

// 具体状态角色
class StartState implements State {

    @Override
    public void doSome(Context context) {
        System.out.println("启动状态");
        context.setState(this);
    }

}

class StopState implements State {

    @Override
    public void doSome(Context context) {
        System.out.println("停止状态");
        context.setState(this);
    }

}
