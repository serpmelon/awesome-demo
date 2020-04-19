package com.togo;

import com.togo.lesson1.*;
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
}
