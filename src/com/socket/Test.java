package com.socket;

import org.java_websocket.drafts.Draft_6455;

import java.net.UnknownHostException;

/**
 * @Title com.socket
 */

public class Test {

    public static void main(String[] args) {
        WebSocketService webSocketService = null;
        try {
            webSocketService = new WebSocketService(9002, new Draft_6455());
            webSocketService.setConnectionLostTimeout(0);
            webSocketService.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
