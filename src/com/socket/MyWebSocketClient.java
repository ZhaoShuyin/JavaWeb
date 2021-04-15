package com.socket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Title com.socket
 */

public class MyWebSocketClient extends WebSocketClient {

    private static String TAG = "客户端";

    public MyWebSocketClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
        System.out.println(TAG + " ======== 构造方法 ");
    }

    public MyWebSocketClient(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders) {
        super(serverUri, protocolDraft, httpHeaders);
        System.out.println(TAG + " ======== 构造方法 ");
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println(TAG + " onOpen ");
        send("device:0001");
    }

    @Override
    public void onMessage(String s) {
        System.out.println(TAG + " onMessage " + s);
    }

    @Override
    public void onMessage(ByteBuffer buffer) {
        super.onMessage(buffer);
        int offset = buffer.arrayOffset();
        System.out.println(TAG + " offset: " + offset);
        if (buffer.hasArray()) {
            byte[] array = buffer.array();
            System.out.println(TAG + " onMessage \n" + Arrays.toString(array));
        }
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
            Map<String, String> httpHeaders = new HashMap<>();
            httpHeaders.put("zzz", "123");
            MyWebSocketClient client = new MyWebSocketClient(new URI("ws://127.0.0.1:9003"), httpHeaders);//192.168.1.125
            client.connect();
            System.out.println(TAG + " client.connect()");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
