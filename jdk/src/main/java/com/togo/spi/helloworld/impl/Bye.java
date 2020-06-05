package com.togo.spi.helloworld.impl;

import com.togo.spi.helloworld.GreetOrBye;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 7:03 下午 2020/6/5
 **/
public class Bye implements GreetOrBye {

    @Override
    public String say(String name) {
        return "bye " + name;
    }
}
