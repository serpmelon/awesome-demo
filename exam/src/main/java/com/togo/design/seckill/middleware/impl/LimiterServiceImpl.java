package com.togo.design.seckill.middleware.impl;

import com.togo.design.seckill.middleware.LimiterService;

import java.util.concurrent.TimeUnit;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 下午6:29 2022/3/6
 **/
public class LimiterServiceImpl implements LimiterService {

    @Override
    public boolean tryAcquire() {
        return false;
    }

    @Override
    public boolean tryAcquire(long timeout, TimeUnit unit) {
        return false;
    }
}
