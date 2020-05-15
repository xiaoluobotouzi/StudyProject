package com.uzi.javaIo.mk;

import org.assertj.core.util.Lists;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @Description: 服务端
 * @Date: 2020/4/3
 * ...
 */
public class Server {

    /**
     * 启动服务端
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // 创建服务端 socket，监听终端端口
        ServerSocket serverSocket = new ServerSocket(9900);
        while (true) {
            final Socket socket = serverSocket.accept(); // 该方法会阻塞
            new Thread(new Runnable() {
                public void run() {
                    try {
                        handler(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    static List<LocationData> locationDataList = Lists.newArrayList();

    /**
     * 接收处理终端数据
     * @param socket
     * @throws IOException
     */
    private static void handler(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        // 接收客户端的数据，该方法会阻塞
        int read = socket.getInputStream().read(bytes);
        if (read != -1) {
            String json = new String(bytes, 0, read);
            System.out.println("接收到客户端的数据：" + json);

            // 基于内存
            locationDataList.add(GetObjectMapper.getObjectMapper().readValue(json, LocationData.class));
            ReturnData.getReturnData().setLocationDataList(locationDataList);

            // 数据持久化
            // es redis mongo 首选
        }
    }

}
