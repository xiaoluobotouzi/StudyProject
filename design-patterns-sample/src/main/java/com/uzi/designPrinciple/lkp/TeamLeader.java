package com.uzi.designPrinciple.lkp;

/**
 * @Description: TODO
 * @Author: LIU.KL
 * @Date: 2019/10/21
 * ...
 */
public class TeamLeader {
    public void reportPhone(){
        for (int i = 0; i < 10; i++) {
            System.out.println(new PhoneBusiness().sale("huawei note " + i, 10325.55 + i));
        }
    }
}
