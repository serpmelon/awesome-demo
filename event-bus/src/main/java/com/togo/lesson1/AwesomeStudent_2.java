package com.togo.lesson1;

import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 7:24 下午 2020/4/19
 **/
public class AwesomeStudent_2 {

    @Subscribe
    public void 科三分数(Double obj) {

        System.out.println("科三" + obj);
    }
}
