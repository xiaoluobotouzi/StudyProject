package com.uzi.javaCommonClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName: DateSample
 * @Description: 时间类 示例
 * @Author: uziJames
 * @Date 2020/3/14 17:17
 * ...
 */
public class DateSample {

    public static void main(String[] args) {

//        dataUzi();

//        simpleDateFormatUzi();

        calendarUzi();

//        calendarDisplay();


    }

    public static void calendarUzi() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        System.out.println("ERA: " + calendar.get(Calendar.ERA));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: " + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
        System.out.println("DST_OFFSET: " + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));

    }

    public static void calendarDisplay() {
        Calendar c = new GregorianCalendar(2020, 03, 15);
        Calendar ca = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
        Calendar temp = new GregorianCalendar(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH) + 1, 1);
        System.out.println("\t\t" + ca.get(Calendar.YEAR) + "年\t" + (ca.get(Calendar.MONTH) + 1) + "月");
        System.out.println();
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        for (int i = 1; i < ca.get(Calendar.DAY_OF_WEEK); i++)
            System.out.print("\t");
        do {
            if (ca.get(Calendar.DAY_OF_WEEK) == 7)
                System.out.println(ca.get(Calendar.DAY_OF_MONTH) + "\t");
            else
                System.out.print(ca.get(Calendar.DAY_OF_MONTH) + "\t");

            ca.add(Calendar.DAY_OF_MONTH, 1);
        } while (ca.get(Calendar.MONTH) != temp.get(Calendar.MONTH));

    }


    /**
     * data类
     */
    public static void dataUzi() {
        //使用Date类需要 import java.util.Date; 导入这个包才可以使用
        //通过new关键创建date对象
        Date date = new Date();

        //输出系统当前时间
        System.out.println(date);
        //输出1970-1-1 00:00:00到现在这个时间所过的毫秒数
        System.out.println(date.getTime());

        // 将毫秒级数据转换为Date格式日期
        Date date2 = new Date(1550847957698L);
        System.out.println(date2);

        //获取当前年份，年份是从1900年之后开始算的
        int year = date.getYear();
        System.out.print("今天是");
        System.out.print(1900 + year);
        System.out.print("年");

        //获取当前月份，月份默认从0开始
        int month = date.getMonth();
        System.out.print(1 + month);
        System.out.print("月");

        //获取当前几号
        int date1 = date.getDate();
        System.out.print(date1 + "号");

        //获取当前星期几
        int day = date.getDay();
        System.out.println("星期" + day);

        //获取当前时间小时
        int hours = date.getHours();
        System.out.print("北京时间" + hours + "点");

        //获取当前时间分钟
        int minutes = date.getMinutes();
        System.out.print(minutes + "分");

        //获取当前时间秒
        int seconds = date.getSeconds();
        System.out.print(seconds + "秒");
    }

    /**
     * SimpleDateFormat 时间格式转换
     */
    public static void simpleDateFormatUzi() {
        // 通过new关键创建date对象
        Date date = new Date();
        System.out.println("转换前：" + date);
        // 需要 import java.text.SimpleDateFormat; 这个包才可以使用
        // 时间格式转换类
        SimpleDateFormat sdf = new SimpleDateFormat();
        String format = sdf.format(date);
        System.out.println("转换后：" + format);

        System.out.println("--------------------------");

        // 通过new关键创建date对象
        Date date2 = new Date();
        System.out.println("转换前：" + date2);
        // 需要 import java.text.SimpleDateFormat; 这个包才可以使用
        // 时间格式转换类
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format2 = sdf2.format(date2);
        System.out.println("转换后：" + format2);
    }
}
