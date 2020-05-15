package com.uzi.javaIo.mk;

import java.util.List;

/**
 * @Description: 返回数据报文
 * @Date: 2020/4/3
 * ...
 */
public class ReturnData {

    private List<LocationData> locationDataList;

    private static ReturnData singleton = new ReturnData();

    private ReturnData(){}

    public static ReturnData getReturnData() {
        return singleton;
    }

    public List<LocationData> getLocationDataList() {
        return locationDataList;
    }

    public void setLocationDataList(List<LocationData> locationDataList) {
        this.locationDataList = locationDataList;
    }

}
