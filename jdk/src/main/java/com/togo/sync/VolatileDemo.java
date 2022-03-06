package com.togo.sync;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 2:57 下午 2020/10/16
 **/
public class VolatileDemo extends Thread {

    private static boolean flag = false;
    private static Map<String, Object> map;
    CountDownLatch countDownLatch;

    public VolatileDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println("start " + getName());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run " + getName());
        if (!flag) {
//            synchronized (VolatileDemo.class) {
                if (!flag) {
                    System.out.println("#######################" + getName());
                    map = new HashMap<>();
//                    map.put("sss", 123);
                    flag = true;
                }
//            }
        }
        if (map == null)
            System.out.println("error");
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 3000; i++) {
            VolatileDemo demo = new VolatileDemo(countDownLatch);
            demo.start();
        }

        countDownLatch.countDown();


    }
}
