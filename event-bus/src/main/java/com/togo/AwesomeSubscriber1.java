package com.togo;

import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:04 上午 2020/4/17
 **/
public class AwesomeSubscriber1 {

    @Subscribe
    public void listen(Object obj) {
        System.out.println(obj);
        System.out.println(this.getClass().getName());
    }

    @Subscribe
    public void listen1(Object obj) {
        System.out.println(obj);
        System.out.println(this.getClass().getName());
    }
}
