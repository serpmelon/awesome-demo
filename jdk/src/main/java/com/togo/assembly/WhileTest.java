package com.togo.assembly;

import java.util.concurrent.TimeUnit;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 8:18 下午 2020/10/27
 **/
public class WhileTest {

    public static boolean flag = true;

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        }).start();
        test();
    }

    public static void test() {
        while (flag){
            try {
                TimeUnit.MILLISECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("stop");
    }
}
