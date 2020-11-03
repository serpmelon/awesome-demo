package com.togo.spring.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:29 上午 2020/11/3
 **/
@Component
public class ApplicationStartListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationStartingEvent) {
            System.out.println("starting event: " + event);
        } else {
            System.out.println("other event: " + event);
        }
    }
}
