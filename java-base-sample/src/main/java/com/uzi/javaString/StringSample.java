package com.uzi.javaString;

/**
 * @ClassName: StringSample
 * @Description: String 示例
 * @Author: uziJamesi
 * @Date 2020/3/10 21:14
 * ...
 */
public class StringSample {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello，");
        stringBuffer.append("World");
        System.out.println(stringBuffer);

        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Hello").append("Hello");
        System.out.println(stringBuffer2);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你好，");
        stringBuilder.append("世界");
        System.out.println(stringBuilder);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("你好").append("你好");
        System.out.println(stringBuilder2);
    }
}
