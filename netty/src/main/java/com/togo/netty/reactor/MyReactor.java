package com.togo.netty.reactor;

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
 * Time    : 9:20 上午
 * ---------------------------------------
 * Desc    :
 */
public class MyReactor implements Runnable {
    final Selector selector;
    final ServerSocketChannel serverSocket;

    public MyReactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> it = selected.iterator();
                while (it.hasNext()) {
                    dispatch(it.next());
                }
                selected.clear();
            }
        } catch (IOException ex) {

        }
    }

    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable) key.attachment();
        if (r != null) {

            r.run();
        }
    }

    class Acceptor implements Runnable {

        @Override
        public void run() {

            try {
                SocketChannel c = serverSocket.accept();
                if (c != null) {
                    new Handler(selector, c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static final class Handler implements Runnable {

        SocketChannel socket;
        SelectionKey sk;

        ByteBuffer input = ByteBuffer.allocate(1000);
        ByteBuffer output = ByteBuffer.allocate(1000);

        static final int READING = 0, SENDING = 1;
        int state = READING;

        public Handler(Selector selector, SocketChannel c) {
            try {
                socket = c;
                c.configureBlocking(false);
                sk = socket.register(selector, 0);
                sk.attach(this);
                sk.interestOps(SelectionKey.OP_READ);
                selector.wakeup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            try {
                if (state == READING) {
                    read();
                }
            } catch (IOException e) {

            }
        }

        void read() throws IOException {
            socket.read(input);
        }

        void send() {

        }
    }
}
