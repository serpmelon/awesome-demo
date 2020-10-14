package com.togo.spring.annotation.jdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 8:34 上午 2020/6/9
 **/
@Service
public class PostSecondService {

    @Autowired
    private PostFirstService firstService;

//    @PostConstruct
    public void print() {
        System.out.println("second " + this.getClass().getName());
        System.out.println("second " + firstService.getClass().getName());
        System.out.println("second ########");
        firstService.print();
        System.out.println("second #########");
    }
}
