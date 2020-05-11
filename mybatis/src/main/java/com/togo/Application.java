package com.togo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:14 下午 2020/4/30
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.ziroom.trade.rent.inquire.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
