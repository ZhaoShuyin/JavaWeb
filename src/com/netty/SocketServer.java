package com.netty;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Netty的Socket服务
 */
public class SocketServer {

    public static void main(String[] args) {
        SocketServer server = new SocketServer("测试服务器");
        server.init(3901);
    }

    private String name;

    private ServerBootstrap boot;
    private EventLoopGroup bosses;
    private EventLoopGroup works;
    private Channel channel;


    public SocketServer(String name) {
        this.name = name;
    }

    public void init(int port) {
        // 创建用于监听accept的线程池
        bosses = new NioEventLoopGroup();
        // 创建用于处理队列和数据的线程池
        works = new NioEventLoopGroup();
        //启动器
        boot = new ServerBootstrap();
        boot.group(bosses, works);                           //添加线程池
        boot.channel(NioServerSocketChannel.class);          //指定使用的channel类
        boot.option(ChannelOption.SO_BACKLOG, 128);    //tcp缓冲区/握手连接的队列长度
        boot.option(ChannelOption.SO_KEEPALIVE, false); //保持长链接
        //设置Handler
        boot.handler(new LoggingHandler(LogLevel.INFO));     //设置主通道的处理器
        boot.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline().addLast(new ServerHandler());
            }
        });
        //开启服务
        try {
            ChannelFuture sync = boot.bind(port).sync(); //绑定端口,开启
            System.out.println("开启服务");
            channel = sync.channel();
            channel.closeFuture().sync();                //等待关闭
            System.out.println("关闭服务");
        } catch (InterruptedException e) {
            e.printStackTrace();
            String s = "服务异常 : " + e.toString();
            System.out.println(s);
        } finally {
            bosses.shutdownGracefully();
            works.shutdownGracefully();
            System.out.println("结束服务");
        }
    }

    /**
     * 关闭服务器
     */
    public void close() {
        if (channel != null)
            channel.close();
        if (bosses != null)
            bosses.shutdownGracefully();
        if (works != null)
            works.shutdownGracefully();
    }


    public class ServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            int length = buf.readableBytes();
            byte[] bytes = new byte[length];
            buf.readBytes(bytes);
            buf.release();
            System.out.println(Arrays.toString(bytes));
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            byte[] response = new byte[10];
            ByteBuf encoded = ctx.alloc().buffer(response.length * 2);
            encoded.writeBytes(response);
            ctx.write(encoded);
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }


}
