package com.uzi.javaException;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @Description: 异常示例
 * @Author: LIU.KL
 * @Date: 2020/5/9
 * ...
 */
public class ExceptionSample {

    public static void main(String[] args) {

//        Throwable throwable = new Throwable();
//
//        Exception exception = new Exception();

//        String s1 = exceptionSample1();// 1243
//        System.out.print(s1);
//
//        System.out.println();
//
//        String s2 = exceptionSample2(); // 243
//        System.out.print(s2);
//
//
//        String s3 = exceptionSample3();// 12456
//        System.out.print(s3);
//
//        System.out.println();
//
//        String s4 = exceptionSample4(); // 2456
//        System.out.print(s1);

        try {
            throwsSampleController("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 控制层 处理不了的异常 继续往上抛  throws IOException
     * @param str
     * @return
     * @throws IOException
     */
    public static String throwsSampleController(String str) throws IOException {
        try {
            throwsSampleService(str);
        } catch (IllegalArgumentException e) { // 只捕获我们在service自己抛出的异常，进行处理
            e.printStackTrace();
            return "{\"code\" : \"1\", \"msg\":\""+e.getMessage()+"\"}";
        }
        return "{\"code\" : \"0\", \"msg\":\"success\"}";
    }

    public static void throwsSampleService(String str) throws IOException {
        // 校验参数，不合法，抛出异常，阻止代码继续执行
        if(StringUtils.isEmpty(str)){
            throw new IllegalArgumentException("参数不能为空");
        }

        System.out.println(str);

        File file = new File(str);
        // 文件不存在异常 我们可以捕获，然后抛出我们自己能处理看的懂的异常
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("文件不存在");
        }

        // 真正的 IO 异常，我们捕获了 也处理不了它，往上抛出去是正确的选择
        is.read();

        System.out.println(str);
    }


    public static String throwsSampleController2(String str) throws IOException {
        String s = throwsSampleService2("");
        if("200".equals(s)){
            return "success";
        }else{
            return s;
        }
    }

    public static String throwsSampleService2(String str) {
        if(StringUtils.isEmpty(str)){
            return "参数不能为空";
        }
        System.out.println(str);
        return "200";
    }

    public static String exceptionSample1() {
        try{
            System.out.print("1");
            int i = 1 / 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("2");
            return "3";
        }finally {
            System.out.print("4");
        }
        System.out.print("5");
        return "6";
    }

    public static String exceptionSample2() {
        try{
            int i = 1 / 0;
            System.out.print("1");
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("2");
            return "3";
        }finally {
            System.out.print("4");
        }
        System.out.print("5");
        return "6";
    }

    public static String exceptionSample3() {
        try{
            System.out.print("1");
            int i = 1 / 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("2");
        }finally {
            System.out.print("4");
        }
        System.out.print("5");
        return "6";
    }

    public static String exceptionSample4() {
        try{
            int i = 1 / 0;
            System.out.print("1");
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("2");
        }finally {
            System.out.print("4");
        }
        System.out.print("5");
        return "6";
    }

}
