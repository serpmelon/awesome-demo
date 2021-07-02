package com.togo.netty.daily.day9;

import io.netty.util.AttributeKey;

/**
 * @author taiyanan
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
