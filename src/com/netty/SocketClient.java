package com.netty;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Title com.netty
 */

public class SocketClient {

    /**
     * 十六进制转int
     *
     * @param c
     * @return
     */
    private static int toByte(char c) {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);
        throw new RuntimeException("Invalid hex char '" + c + "'");
    }

    /**
     * 十六进制字符串转字节数组
     *
     * @param hexString 如：FE00120F0E
     * @return
     */
    public static byte[] hexStringToByteArray(String hexString) {
        int length = hexString.length();
        byte[] buffer = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            buffer[i / 2] = (byte) ((toByte(hexString.charAt(i)) << 4) | toByte(hexString.charAt(i + 1)));
        }

        return buffer;
    }

    public static void main(String[] args) {

        SocketClient client = new SocketClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                client.connect("39.101.177.253",8000);
                client.connect("127.0.0.1", 9000);
            }
        }).start();



//        客户端发送数据
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    FileReader reader = new FileReader("D:/Test/apk/4G_1.txt");
                    int numbwre = 0;
                    char[] cbuf = new char[3];
                    byte[] byt1 = new byte[42210];
                    while (reader.read(cbuf) != -1) {
                        byt1[numbwre++] = (byte) ((toByte(cbuf[0]) << 4) | toByte(cbuf[1]));
                    }
                    System.out.println("numbwre : " + numbwre);
                    reader.close();
                    client.sendBytes(byt1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 10000);
    }

    public Channel channel;

    public void sendMessage(String s) {
        sendBytes(s.getBytes());
    }

    public void sendBytes(byte[] bytes) {
        if (channel != null) {
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            writeBuffer.rewind();
            ByteBuf buf = Unpooled.copiedBuffer(writeBuffer);   // 转为ByteBuf
            channel.writeAndFlush(buf);                         // 写消息到管道
            writeBuffer.clear();                                // 清理缓冲区
            System.out.println("发送 " + bytes.length);
//            System.out.println("发送: "+Arrays.toString(bytes));
        }
    }


    public void connect(String host, int port) {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap boot = new Bootstrap();
        boot.group(group);
        boot.channel(NioSocketChannel.class);
        boot.option(ChannelOption.SO_KEEPALIVE, false);
        boot.option(ChannelOption.TCP_NODELAY, true);
        boot.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline().addLast(new MyHandler());
            }
        });
        try {
            System.out.println("客户端启动");
            ChannelFuture sync = boot.connect(host, port).sync();
            channel = sync.channel();
            System.out.println("客户端连接");
            channel.closeFuture().sync();
            System.out.println("客户端关闭");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("客户端异常:" + e.toString());
        } finally {
            System.out.println("客户端关闭...");
            group.shutdownGracefully();
        }
    }


    public class MyHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            int length = buf.readableBytes();
            byte[] bytes = new byte[length];
            buf.readBytes(bytes);
            buf.release();
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }


    private static byte[] getBytes() {
        byte[] bytes = new byte[938];

        bytes[0] = 0x77;          //报头
        bytes[1] = (byte) 0xcc;   //报头

        bytes[2] = 0x00;
        bytes[3] = 0x00;
        bytes[4] = 0x00;
        bytes[5] = 0x01;

        bytes[6] = 0x00;   //报计数
        bytes[7] = 0x00;
        bytes[8] = 0x01;

        bytes[9] = 0x09;  //电池电量


        bytes[10] = (byte) 0xff;   //导联
        bytes[11] = (byte) 0xff;   //导联
        int index = 12;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 66; j++) {
                if (j > 1) {
                    bytes[index] = 0x05;
                } else {
                    bytes[index] = 0x01;
                }
                index++;
            }
        }
        bytes[936] = (byte) 0xff;
        bytes[937] = (byte) 0xa3;

        return bytes;
    }

}
