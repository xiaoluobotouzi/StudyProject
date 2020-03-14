package com.uzi.designPrinciple.carp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/10/22
 * ...
 */
public class UserDao {

    private DBConnection dbConnection;
    public void setDbConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void addUser(){
        String conn = dbConnection.getConnection();
        System.out.println("获得 " + conn + "成功添加用户");
    }

}
