package com.netty;


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

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                client.connect("39.101.177.253",8000);
                client.connect("127.0.0.1", 9000);
            }
        }).start();
        //客户端发送数据
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
//                client.sendMessage(String.valueOf(System.currentTimeMillis()));
                client.sendBytes(new byte[1000*2]);
            }
        }, 1000, 6000);
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
            System.out.println("发送 "+bytes.length);
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

}
