package com.togo;

import com.togo.lesson1.*;
import com.togo.lesson2.ErrorSub;
import com.togo.lesson2.MultiThreadSub;
import org.junit.Test;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:45 下午 2020/4/16
 **/
public class EventBusTest {

    @Test
    public void 科一() {

        AwesomeEventBusDriver.register(new AwesomeStudent());
        AwesomeEventBusDriver.register(new AwesomeStudent());
        AwesomeEventBusDriver.publishAnything("通过~");
    }

    @Test
    public void 科二() {

        AwesomeEventBusDriver.register(new AwesomeStudent_1());
        AwesomeEventBusDriver.publishAnything("通过~");
        AwesomeEventBusDriver.publishAnything(100);
    }

    @Test
    public void 科三() {

        AwesomeEventBusDriver.register(new AwesomeStudent_1());
        AwesomeEventBusDriver.register(new AwesomeStudent_2());
        AwesomeEventBusDriver.publishAnything(100);
        AwesomeEventBusDriver.publishAnything(90.5);
    }

    @Test
    public void 科四() {

        AwesomeEventBusDriver.register(new AwesomeStudent_1());
        AwesomeEventBusDriver.register(new AwesomeStudent_2());
        AwesomeEventBusDriver.register(new AwesomeCoach());
        AwesomeEventBusDriver.publishAnything(100);
        AwesomeEventBusDriver.publishAnything(90.5);
        AwesomeEventBusDriver.publishAnything(new AwesomeMessageEvent("教练通融下"));
        AwesomeEventBusDriver.publishAnything(new AwesomeMoneyEvent("教练这是点小意思~"));
    }

    @Test
    public void 同步开车() {

        AwesomeEventBusDriver.register(new AwesomeAsyncSubscriber());

        AwesomeEventBusDriver.publishAnything("xxxx");
        AwesomeEventBusDriver.publishAnything(90);
        AwesomeEventBusDriver.publishAnything(100L);
    }

    @Test
    public void 异步开车() throws InterruptedException {

        AwesomeEventBusDriver.registerAsync(new AwesomeAsyncSubscriber());

        AwesomeEventBusDriver.publishAsyncAnything("xxxx");
        AwesomeEventBusDriver.publishAsyncAnything(100L);
        AwesomeEventBusDriver.publishAsyncAnything(90);

        int i = 0;
        while (AwesomeAsyncSubscriber.running) {

            Thread.sleep(1000);
            i++;
            System.out.println(i + "s");
        }
    }

    @Test
    public void 异常开车() {

        AwesomeEventBusDriver.register(new ErrorSub());

        try {

            AwesomeEventBusDriver.publishAnything("xxxx");
        } catch (Exception e) {
            System.out.println(123123);
            e.printStackTrace();
        }
        AwesomeEventBusDriver.publishAnything(90);
        AwesomeEventBusDriver.publishAnything(100L);
    }

    @Test
    public void 多线程开车() throws InterruptedException {
        MultiThreadSub threadSub = new MultiThreadSub();

        AwesomeEventBusDriver.register(threadSub);
        int count = 10000;
        Thread t1 = new Thread(() -> {

            int c1 = count;
            while (c1 > 0) {
                c1--;
                AwesomeEventBusDriver.publishAnything(1);
            }
        });

        Thread t2 = new Thread(() -> {

            int c1 = count;
            while (c1 > 0) {
                c1--;
                AwesomeEventBusDriver.publishAnything(1);
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        threadSub.print();
    }
}
