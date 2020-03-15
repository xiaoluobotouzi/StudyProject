package com.uzi.javaRegexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RegexpSample
 * @Description: java 正则表达式
 * @Author: uziJamesi
 * @Date 2020/3/15 22:08
 * ...
 */
public class RegexpSample {

    public static void main(String[] args) {
//        regexpUzi();
        regexpUzi2();
    }


    public static void regexpUzi2() {
        String str = "中";
        String pattern = "[\u4e00-\u9fa5]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
    }

    public static void regexpUzi() {
        String pattern = "^[a]|b$";
        String str = "b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
    }
}
