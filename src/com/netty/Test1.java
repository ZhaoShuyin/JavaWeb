package com.netty;

/**
 * @Title com.netty
 * @date 2021/4/16
 * @autor Zsy
 */

public class Test1 {
    public static void main(String[] args) {
        SocketClient client = new SocketClient("1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                client.connect("127.0.0.1", 9000);
            }
        }).start();
        client.start();
    }
}
