package com.uzi.javaIo.file;

import java.io.File;
import java.io.IOException;

/**
 * @Description: File class 示例
 * @Author: LIU.KL
 * @Date: 2020/8/27
 * ...
 */
public class FileSample {

    public static void main(String[] args) throws IOException {
        fileTest();
    }

    public static void fileTest() throws IOException {

        // 只是一个实例，并未有任何操作
        File file = new File("D:" + File.separatorChar + "a" + File.separatorChar + "1.txt");

        // 文件或目录是否存在
        if(file.exists()){
            System.out.println("file 存在");
        }

        // 创建文件，文件的父目录一定要存在，否则：java.io.IOException: 系统找不到指定的路径
        file.createNewFile();

        System.out.println("file 内容长度：" + file.length());

        file = new File("D:" + File.separatorChar + "a" + File.separatorChar + "b");
        // 创建目录，只会创建父目录都存在的最后一层目录
        file.mkdir();

        file = new File("D:" + File.separatorChar + "b" + File.separatorChar + "c");
        // 级联创建目录，一些必要但不存在的父目录，不存在都会创建出来
        file.mkdirs();

        // 是不是一个标准的文件
        if(file.isFile()){
            System.out.println("file 是个文件");
        }

        // 是不是一个目录
        if(file.isDirectory()){
            System.out.println("file 是个目录");
        }

        file = new File("D:" + File.separatorChar + "a");
        // 目录下的所有文件目录，一定要是目录才行
        String[] list = file.list();
        for (String f : list) {
            System.out.println("d:\\a\\" + f);
        }

        file = new File("D:" + File.separatorChar + "a" + File.separatorChar + "1.txt");
        // 删除文件或目录，文件可直接删除，目录只能删除空目录
        file.delete();
        file = new File("D:" + File.separatorChar + "b" + File.separatorChar + "c");
        file.delete();

    }
}
