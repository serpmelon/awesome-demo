package com.togo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:53 下午 2020/11/22
 **/
public class TaskRunner {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        private CountDownLatch downLatch;
        public Reader(CountDownLatch downLatch) {
            this.downLatch = downLatch;
        }
        @Override
        public void run() {
            try {
                downLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!ready) {
                Thread.yield();
            }

            if(number == 0) System.out.println("number == 0");

//            System.out.println(Thread.currentThread().getName() + ": " +  number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(1);
        for(int i = 0; i < 500; i++) {
            new Reader(downLatch).start();
        }
        downLatch.countDown();
        TimeUnit.MILLISECONDS.sleep(1000);
        number = 42;
        ready = true;
    }
}
