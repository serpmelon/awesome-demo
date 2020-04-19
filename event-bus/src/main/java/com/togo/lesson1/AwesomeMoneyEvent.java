package com.togo.lesson1;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:37 下午 2020/4/19
 **/
public class AwesomeMoneyEvent {

    private String message;

    public AwesomeMoneyEvent(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "AwesomeMoneyEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
