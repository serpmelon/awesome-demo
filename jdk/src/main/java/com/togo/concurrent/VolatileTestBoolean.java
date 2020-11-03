package com.togo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:38 上午 2020/10/23
 **/
public class VolatileTestBoolean  {

    public static boolean flag = false;


    public static void main(String[] args) {

        T1 t1 = new T1();
        t1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T2 t2 = new T2();
        t2.start();
    }

    public static class T1 extends Thread{

        @Override
        public void run() {
            while (!flag) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(500L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("t1");
//                flag = false;
            }
            System.out.println("flag1 " + flag);
        }
    }

    public static class T2 extends Thread{

        @Override
        public void run() {
            flag = true;
            System.out.println("flag2 " + flag);
        }
    }
}
