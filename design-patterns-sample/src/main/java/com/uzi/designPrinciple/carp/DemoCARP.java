package com.uzi.designPrinciple.carp;

/**
 * @Description: 合成复用原则 -demo CARP
 * @Author: LIU.KL
 * @Date: 2019/10/22
 * ...
 */
public class DemoCARP {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.setDbConnection(new OracleConnection());
        userDao.addUser();
    }
}
