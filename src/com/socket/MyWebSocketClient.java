package com.socket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Title com.socket
 */

public class MyWebSocketClient extends WebSocketClient {

    private static String TAG = "客户端";

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
        System.out.println(TAG + " ======== 构造方法 ");
    }

    public MyWebSocketClient(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
        System.out.println(TAG + " ======== 构造方法 ");
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println(TAG + " onOpen ");
    }

    @Override
    public void onMessage(String s) {
        System.out.println(TAG + " onMessage " + s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println(TAG + " onClose " + s);
    }

    @Override
    public void onError(Exception e) {
        System.out.println(TAG + " onError " + e.toString());
    }

    public static void main(String[] args) {
        try {
            MyWebSocketClient client = new MyWebSocketClient(new URI("ws://192.168.0.154:50000"));
            client.connect();
            System.out.println(TAG + " client.connect()");
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!client.isClosed()) {
                        String text = String.valueOf(System.currentTimeMillis());
                        client.send(text);
                        System.out.println("client.send " + text);
                    } else {
                        System.out.println("未连接");
                    }
                }
            }, 5000);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
