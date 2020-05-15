package com.uzi.javaIo.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * 终端
 */
public class Client {

    /**
     * run client main
     * @param args
     * @throws Exception
     */
    public static void main(String... args) throws Exception {
        initClient();
    }

    /**
     * 初始化终端
     */
    public static void initClient() throws IOException, ExecutionException, InterruptedException {
        // 打开通道
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();

        // 创建连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9900)).get();

        // 往服务端写数据
        socketChannel.write(ByteBuffer.wrap("HelloServer".getBytes()));

        // 字节缓冲
        ByteBuffer buffer = ByteBuffer.allocate(512);

        // 读取服务端响应数据
        Integer len = socketChannel.read(buffer).get();
        if (len != -1) {
            System.out.println("客户端收到信息：" + new String(buffer.array(), 0, len));
        }
    }
}