package com.togo.lesson1;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:30 下午 2020/4/19
 **/
public class AwesomeCoach {

    @Subscribe
    public void all(DeadEvent event) {

        System.out.println(event);
    }
}
