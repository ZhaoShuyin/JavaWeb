package com.netty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title com.netty
 * @date 2021/4/16
 * @autor Zsy
 */

public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    SocketClient client = new SocketClient(String.valueOf(finalI));
                    client.connect("127.0.0.1", 9000);
                    client.start();
                }
            });
        }
    }

}
