package com.togo;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @Author taiyn
 * @Description
 * @Date 10:35 上午 2020/4/16
 **/
public class AwesomeEventBusDriver {

    private static EventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));

    private static EventBus eventBus = new EventBus();

    public static void registerAsync(Object object) {
        asyncEventBus.register(object);
    }

    public static void publishAsyncAnything(Object object) {
        asyncEventBus.post(object);
    }

    public static void register(Object object) {
        eventBus.register(object);
    }

    public static void publishEvent(AwesomeEventObject event) {
        eventBus.post(event);
    }

    public static void publishAnything(Object object) {
        eventBus.post(object);
    }
}