package com.togo.lesson2;

import com.google.common.eventbus.Subscribe;


/**
 * @Author taiyn
 * @Description TODO
 * @Date 4:18 下午 2020/5/12
 **/
public class ErrorSub {

    @Subscribe
    public void error(Object o){
        throw new RuntimeException();
    }

    @Subscribe
    public void noError(Object o){
        System.out.println("######");
    }

}

