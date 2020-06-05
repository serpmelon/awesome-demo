package com.togo.spi.helloworld;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 7:05 下午 2020/6/5
 **/
public class Launcher {

    public static GreetOrBye getInstance(String name) {

        ServiceLoader<GreetOrBye> greetOrByeServiceLoader = ServiceLoader.load(GreetOrBye.class);

        Iterator<GreetOrBye> iterator = greetOrByeServiceLoader.iterator();
        while (iterator.hasNext()) {
            GreetOrBye greetOrBye = iterator.next();
            System.out.println(greetOrBye.say(name));
        }

        return null;
    }

    public static void main(String[] args) {

        getInstance("wahahah");
    }
}
