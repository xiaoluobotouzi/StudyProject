package com.uzi.designPatterns.prototypePattern;

import java.io.*;

/**
 * @Description: 原型模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/19
 * ...
 */
public class PrototypeSample {

    public static void main(String[] args) {
//        // 原型对象
//        Student student = new Student("张三", 18);
//        System.out.println("原型Student对象  " + student);

//        // 克隆对象
//        Student clone = student.clone();
//        System.out.println("克隆Student对象  " + clone);
//        clone.setName("张五");
//        System.out.println("克隆Student对象修改name属性  " + clone);
//
//        // 原型对象
//        Teacher teacher = new Teacher("李四", 33);
//        System.out.println("原型Teacher对象  " + teacher);

//        // 克隆对象
//        Teacher cloneT = teacher.clone();
//        System.out.println("克隆Teacher对象  " + cloneT);
//        cloneT.setName("李六");
//        System.out.println("克隆Teacher对象修改name属性  " + cloneT);

        // 原型对象
        Course course = new Course("语文", "xxx");
        Teacher teacher = new Teacher("李四", 33, course);

        // 克隆对象
        Teacher clone = teacher.clone();
        // 修改课程属性
        clone.getCourse().setCourseName("数学");
        clone.getCourse().setCourseInfo("yyy");

        System.out.println("原型对象  " + teacher);
        System.out.println("克隆对象  " + clone);


    }

}

// 不依赖任何第三方
interface MyCloneable<T> {
    T clone();
}

class Student implements MyCloneable {

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // 重写 clone 方法
    @Override
    public Student clone() {
        // ...对象创建复杂的过程
        return new Student(this.name, this.age);
    }

    @Override
    public String toString() {
        return super.hashCode() + " } Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

// 复杂嵌套
class Course implements Cloneable, Serializable{

    static final long serialVersionUID = 1L;

    private String courseName;
    private String courseInfo;

    public Course(String courseName, String courseInfo) {
        this.courseName = courseName;
        this.courseInfo = courseInfo;
    }

    @Override
    public String toString() {
        return super.hashCode() + " } Course{" +
                "courseName='" + courseName + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                '}';
    }

    @Override
    protected Course clone() {
        try{
           return (Course) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }
}


// 使用 jdk 提供的 api
class Teacher implements Cloneable, Serializable{

    static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private Course course;

    public Teacher() {}

    public Teacher(String name, Integer age, Course course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // 重写 clone 方法
    @Override
    protected Teacher clone(){
        try {
//            Teacher teacher = (Teacher) super.clone();
//            teacher.setCourse(teacher.getCourse().clone());
//            return teacher;

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Teacher) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return super.hashCode() + " } Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
