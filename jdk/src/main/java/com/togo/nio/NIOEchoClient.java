package com.togo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author : taiyn
 * Date    : 2021/2/9
 * Time    : 10:15 上午
 * ---------------------------------------
 * Desc    :
 */
public class NIOEchoClient {

    private static SocketChannel client;
    private static ByteBuffer buffer;
    private static NIOEchoClient instance;

    public static NIOEchoClient start() {

        if (instance == null) {
            instance = new NIOEchoClient();
        }

        return instance;
    }

    public static void stop() throws IOException {

        client.close();
        buffer = null;
    }

    private NIOEchoClient() {

        try {
            client = SocketChannel.open(new InetSocketAddress("localhost", 5454));
            buffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {

        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;

        try {
            client.write(buffer);
            buffer.clear();
            client.read(buffer);
            response = new String(buffer.array()).trim();
            System.out.println("response= " + response);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static void main(String[] args) {

        NIOEchoClient start = NIOEchoClient.start();
        String www = start.sendMessage("www");
        System.out.println(www);
    }
}
