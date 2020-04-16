package com.togo;

import java.util.EventObject;

/**
 * @Author taiyn
 * @Description event object
 * @Date 10:39 下午 2020/4/16
 **/
public class AwesomeEventObject extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public AwesomeEventObject(Object source) {
        super(source);
    }

}
