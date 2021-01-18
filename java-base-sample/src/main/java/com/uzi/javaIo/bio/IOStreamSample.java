package com.uzi.javaIo.bio;

import java.io.*;

/**
 * @ClassName: IOStream
 * @Description: IO 流 示例
 * @Author: kunLing
 * @Date 2020/12/21 9:43
 * ...
 */
public class IOStreamSample {

    public static void main(String[] args) throws IOException {

//        byteArrayIOStreamTest();

        fileIOStreamTest();



    }

    private void streamTest() {

        InputStream is;
        OutputStream os;

    }

    /**
     * 文件输入输出流示例
     */
    private static void fileIOStreamTest() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("/a.txt");
            fos = new FileOutputStream("/b.txt");

            // 创建一个缓冲字节数组，可减少IO操作，提高读写效率，一般用于大文件操作
            byte[] byt = new byte[1024];

            // 读取缓冲字节数组长度的字节
//            int read = fis.read(byt);
            int read = fis.read();
            while(read != -1){
//                fos.write(byt, 0, read);
                fos.write(read);
                read = fis.read();
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("系统异常");
        } finally {
            if(null != fos){
                fos.close();
            }
            if(null != fis){
                fis.close();
            }
        }
    }

    /**
     * 字节数组输入输出流示例
     */
    private static void byteArrayIOStreamTest() throws IOException {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        try {
            String ss = "Hello World";
            bis = new ByteArrayInputStream(ss.getBytes());
            bos = new ByteArrayOutputStream();

            int read = bis.read();
            while (read != -1) {
                char c = (char) read;
                System.out.print(" " + c);

                bos.write(read);
                read = bis.read();
            }

            System.out.println();

            System.out.println(bos.toString());
        } finally {
            if(null != bos){
                bos.close();
            }
            if(null != bis){
                bis.close();
            }
        }
    }
}
