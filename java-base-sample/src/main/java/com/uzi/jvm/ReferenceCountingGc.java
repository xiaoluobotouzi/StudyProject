package com.uzi.jvm;

/**
 * @ClassName: ReferenceCountingGc
 * @Description: 引用计数
 * @Author: kunLing
 * @Date 2021/3/2 16:27
 * ...
 */
public class ReferenceCountingGc {

    Object instance = null;

    public static void main(String[] args) {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
    }

}
