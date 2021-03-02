package com.togo.assembly;

import java.util.concurrent.TimeUnit;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 8:18 下午 2020/10/27
 **/
public class WhileTest {

    public static volatile boolean flag = false;

    public static void main(String[] args) {

//        new Thread(()->{
//            try {
//                TimeUnit.MILLISECONDS.sleep(100L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            flag = false;
//        }).start();
//        test();
        test();
    }

    public static void test() {
        flag = true;
        boolean x = flag;
//        while (flag){
//            try {
//                TimeUnit.MILLISECONDS.sleep(1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
