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
public class PostFirstService {

    @Autowired
    private PostSecondService secondService;

//    @PostConstruct
    public void print() {

        System.out.println("first " + this.getClass().getName());
        System.out.println("first " + secondService.getClass().getName());
        System.out.println("first @@@@@@@@@@@@@");
        secondService.print();
        System.out.println("first @@@@@@@@@@@@@@@");
    }
}
