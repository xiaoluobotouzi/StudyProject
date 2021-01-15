package com.uzi.javaIo.bio;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName: IOStream
 * @Description: IO 流 示例
 * @Author: kunLing
 * @Date 2020/12/21 9:43
 * ...
 */
public class IOStreamSample {

    public static void main(String[] args) {

    }

    private void StreamTest(){

        InputStream is;
        OutputStream os;

    }

    private void byteArrayInputStreamTest(){
        String ss = "ABC123";
        InputStream is = new ByteArrayInputStream(ss.getBytes());

    }
}
