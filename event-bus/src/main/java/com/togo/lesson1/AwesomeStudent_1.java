package com.togo.lesson1;

import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 7:24 下午 2020/4/19
 **/
public class AwesomeStudent_1 {

    @Subscribe
    public void 科二(String obj) {

        System.out.println("科二" + obj);
    }

    @Subscribe
    public void 科二分数(Integer obj) {

        System.out.println("科二" + obj);
    }
}
