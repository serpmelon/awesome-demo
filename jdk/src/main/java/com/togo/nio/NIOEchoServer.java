package com.togo.nio;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.rmi.registry.Registry;
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
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 5454));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(256);

        while (true) {

            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();

                if(key.isAcceptable()) {
                    register(selector, serverSocketChannel);
                }

                if(key.isReadable()) {
                    answerWithEcho(buffer, key);
                }

                iterator.remove();
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

    private static void register(Selector  selector, ServerSocketChannel serverSocketChannel) throws IOException {

        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static Process start() throws IOException {

        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = NIOEchoServer.class.getCanonicalName();

        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);
        return builder.start();
    }

}
