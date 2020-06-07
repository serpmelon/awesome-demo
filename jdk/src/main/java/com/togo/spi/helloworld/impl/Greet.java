package com.togo.spi.helloworld.impl;

import com.togo.spi.helloworld.GreetOrBye;


/**
 * @Author taiyn
 * @Description
 * @Date 6:45 下午 2020/6/5
 **/
public class Greet implements GreetOrBye {

    @Override
    public String say(String name) {
        return "hi " + name;
    }
}
