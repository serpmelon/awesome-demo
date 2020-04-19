package com.togo.lesson1;

import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:00 下午 2020/4/19
 **/
public class AwesomeAsyncSubscriber {

    volatile public static boolean running = true;

    @Subscribe
    public void cpu(Integer money) {

        System.out.println("cpu :" + money);
    }

    @Subscribe
    public void laptop(Long money) throws InterruptedException {

        int count = 3;
        while (count > 0) {
            count--;
            Thread.sleep(1000);
        }
        System.out.println("laptop :" + money);
    }

    @Subscribe
    public void poxn(String seed) throws InterruptedException {

        System.out.println("poxn " + seed);
        System.out.println("downloading ...0%");
        running = true;
        int count = 5;
        while (count > 0) {
            count--;
            Thread.sleep(1000);
        }

        System.out.println("99%...100%");
        running = false;
        System.out.println(running);
    }
}
