package com.uzi.jvm;

/**
 * @ClassName: StackOverflowErrorSample
 * @Description: 栈内存错误示例
 * @Author: uziJames
 * @Date 2021/1/24 16:24
 * ...
 */
public class StackOverflowErrorSample {

    /**
     * -Xss128K
     *      通常只有几百K
     *      决定了函数调用的深度
     *      每个线程都有独立的栈空间
     *      局部变量、参数、分配在栈上
     *      一般栈参数不要求配置很大了，反而适得其反
     *      如果有递归调用，栈就不能小了，很有可能会导致栈溢出.
     *      减少递归调用方法里的局部变量的数量，也可以减少调用空间，可以多调用几次
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("》》》" + count);
        }
    }

    private static int count = 0;

    private static void redo() {
        count++;
        redo();
    }

}
