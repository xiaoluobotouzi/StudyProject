package com.uzi.ioSample.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 服务端
 */
public class Server {

    /**
     * run server main
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        initServer();
    }

    /**
     * 初始化服务端
     * @throws InterruptedException
     * @throws IOException
     */
    public static void initServer() throws InterruptedException, IOException {
        // 定义服务端通道
        final AsynchronousServerSocketChannel serverChannel;

        // 绑定监听端口
        serverChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(9900));

        // 接收连接
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            /**
             * 成功回调处理
             * @param socketChannel
             * @param attachment
             */
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                // 接收终端端连接
                serverChannel.accept(attachment, this);

                // 字符缓冲
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // 读取终端数据
                socketChannel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer buffer) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, result));
                        socketChannel.write(ByteBuffer.wrap("HelloClient".getBytes()));
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer buffer) {
                        exc.printStackTrace();
                    }
                });
            }

            /**
             * 失败回调处理
             * @param exc
             * @param attachment
             */
            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        Thread.sleep(Integer.MAX_VALUE);
    }
}