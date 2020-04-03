package com.uzi.ioSample.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Description: 数据处理
 * @Date: 2020/4/3
 * ...
 */
public class IOData {

    /**
     * run main
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        // 启动服务端
        runServer();

        // 启动终端
        runClient();

        // 运行后台管理系统
        runDms();
    }

    /**
     * 运行终端
     * @throws IOException
     * @throws InterruptedException
     */
    public static void runClient() throws IOException, InterruptedException, ExecutionException {
        int i = 0;
        while (true){
            // 打开通道
            AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();

            // 创建连接
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9900)).get();

            // 构建定位数据
            LocationData locationData = new LocationData(i+"", 116.40, 39.9, "东向西方向", 80, LocalDateTime.now());
            String locationDataJson = GetObjectMapper.getObjectMapper().writeValueAsString(locationData);

            // 往服务端写数据
            socketChannel.write(ByteBuffer.wrap(locationDataJson.getBytes()));

            i++;

            // 线程休眠999ms
            Thread.sleep(999);
        }
    }

    /**
     * 启动服务端
     * @throws IOException
     */
    public static void runServer() throws IOException, InterruptedException {
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
                        String json = new String(buffer.array(), 0, result);

                        try {
                            // 基于内存
                            locationDataList.add(GetObjectMapper.getObjectMapper().readValue(json, LocationData.class));

                            // 数据持久化 （es redis mongo 首选）

                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
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

    /**
     * 运行后台管理系统
     * @throws IOException
     */
    public static void runDms() {
        while (true){
            // 实时获取终端数据
            List<LocationData> clientData = getClientData(new SelectQuery());
            System.out.println("后台管理系统的网页,实时看到终端发送的数据集合：" + clientData);
        }
    }

    // 内存存储终端数据
    static List<LocationData> locationDataList = Lists.newArrayList();

    /**
     * 后台管理系统获取终端数据
     * @return
     */
    public static List<LocationData> getClientData(SelectQuery selectQuery){
        return locationDataList;
    }

    /**
     * 单例 ObjectMapper
     */
    static class GetObjectMapper extends ObjectMapper{

        private GetObjectMapper(){}

        private static GetObjectMapper singleton= new GetObjectMapper();

        public static GetObjectMapper getObjectMapper() {
            return singleton;
        }
    }

    /**
     * 后台管理系统查询终端数据实体
     */
    static class SelectQuery{

    }

    /**
     * 终端发送定位数据包
     */
    static class LocationData {

        /**
         * 终端ID
         */
        private String clientId;

        /**
         * 经度
         */
        private Double longitude;

        /**
         * 纬度
         */
        private Double latitude;

        /**
         * 行驶方向
         */
        private String drivingDirection;

        /**
         * 速度
         */
        private Integer speed;

        /**
         * 定位时间
         */
        private LocalDateTime time;

        public LocationData() {
        }

        public LocationData(String clientId, Double longitude, Double latitude, String drivingDirection, Integer speed, LocalDateTime time) {
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

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
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
}
