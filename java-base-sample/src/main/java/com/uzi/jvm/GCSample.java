package com.uzi.jvm;

/**
 * @ClassName: GCSample
 * @Description: GC 示例
 * @Author: kunLing
 * @Date 2021/3/2 15:40
 * ...
 */
public class GCSample {

    /**
     * 运行参数：-XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] b1 = new byte[58000 * 1024];
        byte[] b2 = new byte[5000 * 1024];
        byte[] b3 = new byte[5000 * 1024];
        byte[] b4 = new byte[5000 * 1024];
        byte[] b5 = new byte[5000 * 1024];
    }
}
