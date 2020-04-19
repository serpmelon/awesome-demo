package com.togo.lesson1;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:37 下午 2020/4/19
 **/
public class AwesomeMessageEvent {

    private String message;

    public AwesomeMessageEvent(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "AwesomeEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
