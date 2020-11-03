package com.togo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:38 上午 2020/10/23
 **/
public class VolatileTest {

    public static AtomicInteger atomicCount = new AtomicInteger(0);
    public static int count = 0;


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            Worker worker = new Worker(countDownLatch);
            worker.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }

    public static class Worker extends Thread{

        CountDownLatch countDownLatch;
        public Worker(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {

//                count.addAndGet(1);
                count++;
            }
            countDownLatch.countDown();
        }
    }


}
