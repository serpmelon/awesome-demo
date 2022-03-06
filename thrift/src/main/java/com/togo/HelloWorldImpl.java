package com.togo;

/**
 * @author : taiyn
 * Date    : 2020/12/24
 * Time    : 9:25 下午
 * ---------------------------------------
 * Desc    :
 */
import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorldService.Iface {

    public HelloWorldImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome";
    }
}
