package com.uzi.jvm;

/**
 * 运行此代码，cpu会飙高
 */
public class HighestCpu {

    /**
     * 一个方法对应一块栈帧内存区域
     *
     * @return
     */
    private int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        HighestCpu cpu = new HighestCpu();
        while (true) {
            cpu.compute();
        }
    }
}