package com.uzi.designPatterns.adapterPattern;

/**
 * @Description: 类适配器 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/1
 * ...
 */
public class ClassAdapter {

    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter();
        powerAdapter.outputDC5v();
    }
}

class Adaptee220v{
    public int output220v(){
        int output = 220;
        System.out.println("正常输出电压 " + output + "V");
        return output;
    }
}

interface Target5v{
    int outputDC5v();
}

class PowerAdapter extends Adaptee220v implements Target5v{

    @Override
    public int outputDC5v() {
        int adapterInput = super.output220v();
        int adapterOutput = adapterInput / 44;
        System.out.println("电源适配器输出电压 " + adapterOutput + "V");
        return adapterOutput;
    }
}
