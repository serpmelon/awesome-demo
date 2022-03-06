package com.togo.design.patterns.singleton;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 上午9:25 2022/3/6
 **/
public class LazyMode {

    private static LazyMode INSTANCE;

    private LazyMode(){}

    public static synchronized LazyMode getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyMode();
        }

        return INSTANCE;
    }
}
