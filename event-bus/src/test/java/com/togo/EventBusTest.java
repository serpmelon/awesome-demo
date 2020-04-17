package com.togo;

import org.junit.Test;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:45 下午 2020/4/16
 **/
public class EventBusTest {

    @Test
    public void test() {

        AwesomeEventBusDriver.register(new AwesomeSubscriber());
        AwesomeEventBusDriver.publishEvent("wawa");
    }
}
