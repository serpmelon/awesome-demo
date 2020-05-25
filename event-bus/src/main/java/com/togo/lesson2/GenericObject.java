package com.togo.lesson2;

import com.google.common.eventbus.Subscribe;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 5:13 下午 2020/5/24
 **/
public class GenericObject<T> {

    @Subscribe
    public void TestGeneric(T obj) {

        System.out.println("generic " + obj);
    }

    @Subscribe
    public void TestPrimitive(int i) {

        System.out.println("primitive " + i);
    }
}
