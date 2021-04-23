package com.netty;

import com.alibaba.fastjson.JSON;
import com.util.ChannelUtil;
import com.util.HexUtil;
import com.util.RecordUtil;

import java.net.SocketAddress;
import java.nio.ByteBuffer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
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

    private static String TAG = "***** Socket";

    private ServerBootstrap boot;
    private EventLoopGroup bosses;
    private EventLoopGroup works;
    private Channel channel;


    public void init(int port) {
        // 创建用于监听accept的线程池
        bosses = new NioEventLoopGroup(1);
        // 创建用于处理队列和数据的线程池
        works = new NioEventLoopGroup(1);
        //启动器
        boot = new ServerBootstrap();
        boot.group(bosses, works);                           //添加线程池
        boot.channel(NioServerSocketChannel.class);          //指定使用的channel类
        boot.option(ChannelOption.SO_BACKLOG, 128);      //tcp缓冲区/握手连接的队列长度
        boot.option(ChannelOption.SO_KEEPALIVE, true); //保持长链接
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
            System.out.println(TAG + "开启服务");
            RecordUtil.error(TAG + "开启服务");
            channel = sync.channel();
            channel.closeFuture().sync();                //等待关闭
            System.out.println(TAG + "关闭服务");
            RecordUtil.error(TAG + "关闭服务");
        } catch (InterruptedException e) {
            e.printStackTrace();
            String s = TAG + "服务异常 : " + e.toString();
            System.out.println(s);
            RecordUtil.error(s);
        } finally {
            bosses.shutdownGracefully();
            works.shutdownGracefully();
            System.out.println(TAG + "结束服务");
            RecordUtil.error(TAG + "结束服务");
        }
    }

    /**
     * 关闭服务器
     */
    public void close() {
        RecordUtil.error(TAG + "关闭服务");
        if (channel != null)
            channel.close();
        if (bosses != null)
            bosses.shutdownGracefully();
        if (works != null)
            works.shutdownGracefully();
    }


    public class ServerHandler extends ChannelInboundHandlerAdapter {

        //byte长度限制 最大:65536
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            int length = buf.readableBytes();
            byte[] readBytes = new byte[length];
            buf.readBytes(readBytes);
            message(ctx, HexUtil.encodeHexStr(readBytes));
            byte[] response = new byte[]{0x01, 0x01};
            if (response != null) {
                ByteBuf encoded = ctx.alloc().buffer(response.length * 2);
                encoded.writeBytes(response);
                ctx.write(encoded);
            }
            ctx.flush();
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
//            message(ctx, " 通信完毕 channelReadComplete ");
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            String jsonString = JSON.toJSONString(cause);
            message(ctx, " 异常 exceptionCaught ==> \n\t" + ChannelUtil.getString(ctx) + " \n\t" + jsonString);
            cause.printStackTrace();
            ctx.close();
        }

        //注册
        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            super.channelRegistered(ctx);
            message(ctx, " 注册 channelRegistered ");
        }

        //通道开启
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
            message(ctx, " 通道开启 channelActive ");
//            respose(ctx);
        }

        //通道关闭
        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            super.channelInactive(ctx);
            message(ctx, " 通道关闭 channelActive ");
        }

        //注销
        @Override
        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
            super.channelUnregistered(ctx);
            message(ctx, " 注销 channelUnregistered ");
        }

        //
        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            super.userEventTriggered(ctx, evt);
            message(ctx, " 事件触发 userEventTriggered ");
        }

        //属性修改
        @Override
        public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
            super.channelWritabilityChanged(ctx);
            message(ctx, " 属性修改 channelWritabilityChanged ");
        }
    }

    public static void message(ChannelHandlerContext ctx, String tag) {
        String s = ctx.name();   //SocketServer$ServerHandler#0
        Channel channel = ctx.channel();
        ChannelId id = channel.id();
        String longText = id.asShortText();
        SocketAddress address = channel.remoteAddress();
        String thread = Thread.currentThread().getName();
        String log = TAG
                + "ctx : "+System.identityHashCode(ctx)
                + "  Thead : < " + thread.substring(thread.length() - 3)
                + " >   channelId: (" + id.asShortText() + ") ("+id.asLongText()+")   address: [" + address + "]  ==> " + tag;
        RecordUtil.log(thread, log);
    }

    public static boolean send(Channel channel, byte[] bytes) {
//        System.out.println(" =========== channel: " + channel + "  isOpen: " + channel.isOpen() + "  isActive: " + channel.isActive() + " ");
        if (!channel.isOpen()) {
            return false;
        }
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        writeBuffer.rewind();
        ByteBuf buf = Unpooled.copiedBuffer(writeBuffer);   // 转为ByteBuf
        channel.writeAndFlush(buf);                         // 写消息到管道
        writeBuffer.clear();                                // 清理缓冲区
        String longText = channel.id().asShortText();
        RecordUtil.log(longText, TAG + "  发送: " + HexUtil.encodeHexStr(bytes));
        return true;
    }


    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.init(9000);
    }
}
