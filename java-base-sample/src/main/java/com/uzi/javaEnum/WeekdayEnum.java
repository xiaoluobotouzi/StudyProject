package com.uzi.javaEnum;

/**
 * @Description: 星期 枚举类
 * @Author: LIU.KL
 * @Date: 2020/4/20
 * ...
 */
public enum WeekdayEnum {

    Monday("01", "星期一"),
    Tuesday("02", "星期二"),
    Wednesday("03", "星期三"),
    Thursday("04", "星期四"),
    Friday("05", "星期五"),
    Saturday("06", "星期六"),
    Sunday("07", "星期日");

    private String code;
    private String name;

    WeekdayEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
