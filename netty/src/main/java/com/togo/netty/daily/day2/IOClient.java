package com.togo.netty.daily.day2;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

/**
 * @author taiyanan
 */
public class IOClient {
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
//
//        new Thread(() -> {
//            int i = 100;
//            Random random = new Random();
//            while (i > 0) {
//                try {
//                    Thread.sleep(random.nextInt(10) * 10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                new Thread(() -> {
//                    try {
//                        Socket socket = new Socket("127.0.0.1", 8000);
//                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
//                    } catch (Exception e) {
//                    }
//                }).start();
//            }
//        }).start();
    }
}
