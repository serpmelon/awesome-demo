package com.togo.netty.daily.day9;


import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author taiyanan
 */
public class LoginUtil {

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {

        Attribute<Boolean> attr = channel.attr(Attributes.LOGIN);
        return attr != null;
    }
}
