package com.uzi.javaIo.mk;

import java.util.Date;

/**
 * @Description: 定位数据包
 * @Date: 2020/4/3
 * ...
 */
public class LocationData {

    private String clientId;
    private Double longitude;
    private Double latitude;
    private String drivingDirection;
    private Integer speed;
    private Date time;

    public LocationData() {
    }

    public LocationData(String clientId, Double longitude, Double latitude, String drivingDirection, Integer speed, Date time) {
        this.clientId = clientId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.drivingDirection = drivingDirection;
        this.speed = speed;
        this.time = time;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDrivingDirection() {
        return drivingDirection;
    }

    public void setDrivingDirection(String drivingDirection) {
        this.drivingDirection = drivingDirection;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LocationData{" +
                "clientId='" + clientId + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", drivingDirection='" + drivingDirection + '\'' +
                ", speed=" + speed +
                ", time=" + time +
                '}';
    }
}
