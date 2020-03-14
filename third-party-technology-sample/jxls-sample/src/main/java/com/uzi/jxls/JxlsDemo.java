package com.uzi.jxls;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JxlsDemo {

    public static void main(String[] args) {
        // 构建数据
        List<StudentBean> studentBeans = buildStudentData();
        // 输入输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 读取模板到输入流
            fis = new FileInputStream("/tmp/file/student-template.xlsx");
            // 指定文件输出流
            fos = new FileOutputStream("/tmp/file/student-" + System.currentTimeMillis() + ".xlsx");
            // bean 上下文
            Context context = new Context();
            // students 对应命令里的  items = "students"  ---》  jx:each(items = "students" var = "student" lastCell = "D3")
            context.putVar("students", studentBeans);
            // 通过流转换，提取数据 输出文件
            JxlsHelper.getInstance().processTemplate(fis, fos, context);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos != null){
                    fos.close();
                }
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<StudentBean> buildStudentData(){
        List<StudentBean> list = new ArrayList<StudentBean>();
        StudentBean sb1 = new StudentBean();
        StudentBean sb2 = new StudentBean();
        StudentBean sb3 = new StudentBean();
        sb1.setName("张三");
        sb2.setName("李四");
        sb3.setName("王五");
        sb1.setAge(20);
        sb2.setAge(19);
        sb3.setAge(21);
        sb1.setRegisterTime(new Date());
        sb2.setRegisterTime(new Date());
        sb3.setRegisterTime(new Date());
        sb1.setClaxx("3.1班");
        sb2.setClaxx("3.2班");
        sb3.setClaxx("3.3班");
        list.add(sb1);
        list.add(sb2);
        list.add(sb3);
        return list;
    }

}
