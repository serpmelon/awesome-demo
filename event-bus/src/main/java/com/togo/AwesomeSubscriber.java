package com.togo;

import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:43 下午 2020/4/16
 **/
public class AwesomeSubscriber {

    @Subscribe
    public void listen(Object obj) {
        System.out.println(obj);
    }

    @Subscribe
    public void listen1(Object obj) {
        System.out.println(obj);
    }
}
