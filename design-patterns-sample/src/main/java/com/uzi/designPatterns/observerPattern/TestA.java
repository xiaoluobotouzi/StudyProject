package com.uzi.designPatterns.observerPattern;

import java.util.List;

/**
 * @Description: 亮神给我写的观察者
 * @Author: ZLL
 * @Date: 2020/6/4
 * ...
 */
public class TestA {

    private List<Listener> listener;

    public void listen(Listener listener) {
        this.listener.add(listener);
    }

    public void publish(){
        for (Listener listener1 : listener) {
            listener1.notice();
        }
    }
}

class Listener {
    public void notice() {
        System.out.println("收到通知了");
    }
}
