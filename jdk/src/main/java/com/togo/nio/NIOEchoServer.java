package com.togo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : taiyn
 * Date    : 2021/2/2
 * Time    : 9:52 上午
 * ---------------------------------------
 * Desc    :
 */
public class NIOEchoServer {

    private static final String POISON_PILL = "POISON_PILL";

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        // TODO taiyn 2021/2/2 9:55 上午 为什么是这个channel? 可以用别的么
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 5555));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(256);

        while (true) {

            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();

            }
        }
    }

    private static void answerWithEcho(ByteBuffer buffer, SelectionKey key) throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.read(buffer);
        if (new String(buffer.array()).trim().equalsIgnoreCase(POISON_PILL)) {

            socketChannel.close();
            System.out.println("stop client");
        } else {

        }
    }
}
