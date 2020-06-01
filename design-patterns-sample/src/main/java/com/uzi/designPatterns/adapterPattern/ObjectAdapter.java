package com.uzi.designPatterns.adapterPattern;

/**
 * @Description: 对象适配器 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/1
 * ...
 */
public class ObjectAdapter {

    public static void main(String[] args) {
        PowerAdapter2 adapter2 = new PowerAdapter2(new Adaptee220V());
        adapter2.output5V();
    }
}

class Adaptee220V{
    public int output220v() {
        int output = 220;
        System.out.println("正常输出电压 " + output + "V");
        return output;
    }
}

interface Target5V{
    int output5V();
}

class PowerAdapter2 implements Target5V{

    Adaptee220V adaptee220V;

    public PowerAdapter2(Adaptee220V adaptee220V){
        this.adaptee220V = adaptee220V;
    }

    @Override
    public int output5V() {
        int i = adaptee220V.output220v();
        int adapterOutput = i / 44;
        System.out.println("电源适配器输出电压 " + adapterOutput + "V");
        return adapterOutput;
    }
}