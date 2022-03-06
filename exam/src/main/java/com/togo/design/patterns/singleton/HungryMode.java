package com.togo.design.patterns.singleton;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 上午9:27 2022/3/6
 **/
public class HungryMode {

    private static HungryMode INSTANCE = new HungryMode();

    private HungryMode(){}

    public static HungryMode getInstance() {
        return INSTANCE;
    }
}
