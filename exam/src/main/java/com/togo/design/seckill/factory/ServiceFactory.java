package com.togo.design.seckill.factory;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 下午7:05 2022/3/6
 **/
public class ServiceFactory {

    public static <T> T create(Class<T> klass){
        try {
            return klass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("create service error!");
        }
    }
}
