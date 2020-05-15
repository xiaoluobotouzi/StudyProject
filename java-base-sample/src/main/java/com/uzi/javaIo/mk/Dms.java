package com.uzi.javaIo.mk;

import java.io.IOException;
import java.util.List;

/**
 * @Description: 后台管理系统 和 接口
 * @Date: 2020/4/3
 * ...
 */
public class Dms {

    public static void main(String[] args) {
        runDms();
    }

    /**
     * 运行后台管理系统（基于内存的不是同一进程，获取不到数据，持久化数据方可获取）
     * @throws IOException
     */
    public static void runDms() {
        while (true){
            // 实时获取终端数据
            List<LocationData> clientData = getClientData(new SelectQuery());
            System.out.println("后台管理系统的页面,实时查看终端数据集合：" + clientData);
        }
    }

    /**
     * 后台管理系统获取终端数据
     * @return
     */
    public static List<LocationData> getClientData(SelectQuery selectQuery){
        return ReturnData.getReturnData().getLocationDataList();
    }

    /**
     * 后台管理系统查询终端数据实体
     */
    static class SelectQuery{

    }

}
