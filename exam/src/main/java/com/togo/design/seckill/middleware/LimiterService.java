package com.togo.design.seckill.middleware;

import java.util.concurrent.TimeUnit;

/**
 * @Author taiyn
 * @Description 限流器
 * @Date 下午5:57 2022/3/6
 **/
public interface LimiterService {

    boolean tryAcquire();

    boolean tryAcquire(long timeout, TimeUnit unit);
}
