package com.togo.lesson2;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:23 下午 2020/5/20
 **/
public class MultiThreadSub {

    private int allowConcurrentSum = 0;
    private int noConcurrentSum = 0;

    @Subscribe
    @AllowConcurrentEvents
    public void addAllow(Integer i) {
        allowConcurrentSum += i;
    }

    @Subscribe
    public void addNo(Integer i) {
        noConcurrentSum += i;
    }

    public void print() {
        System.out.println("allowConcurrentSum: " + allowConcurrentSum);
        System.out.println("noConcurrentSum: " + noConcurrentSum);
    }
}
