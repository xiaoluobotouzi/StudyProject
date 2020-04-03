package com.uzi.ioSample.mk;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Description: 终端
 * @Date: 2020/4/3
 * ...
 */
public class Client {

    /**
     * 运行终端
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int i = 0;
        while (true){
            // 创建 socket
            Socket socket = new Socket("localhost", 9900);

            // 构建定位数据
            LocationData locationData = new LocationData(i+"", 116.40, 39.9, "东向西", 80, new Date());
            String locationDataJson = GetObjectMapper.getObjectMapper().writeValueAsString(locationData);

            // 向服务端发送定位数据
            socket.getOutputStream().write(locationDataJson.getBytes());
            socket.getOutputStream().flush();
            System.out.println("向服务端发送数据完成");

            i++;

            // 线程休眠999ms
            Thread.sleep(999);
        }
    }

}
