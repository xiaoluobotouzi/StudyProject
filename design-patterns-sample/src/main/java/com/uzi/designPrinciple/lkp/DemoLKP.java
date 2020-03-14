package com.uzi.designPrinciple.lkp;

/**
 * @Description: 最少知道原则 --LKP （迪米特法则）
 * @Author: LIU.KL
 * @Date: 2019/10/21
 * ...
 */
public class DemoLKP {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.checkPhone(teamLeader);
    }
}
