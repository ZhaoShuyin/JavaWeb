package com.util;

import java.net.SocketAddress;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Title com.transit.util
 * @date 2021/4/8
 * @autor Zsy
 */

public class ChannelUtil {

    public static String getString(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        String longText = channel.id().asShortText();
        SocketAddress address = channel.remoteAddress();
        String thread = Thread.currentThread().getName();
        return "Thead : < " + thread + " >   channelId: (" + longText + ")   address: [" + address + "]  ==> ";
    }

}
