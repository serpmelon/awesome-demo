package com.togo.nio.buffer;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : taiyn
 * Date    : 2021/2/24
 * Time    : 9:16 上午
 * ---------------------------------------
 * Desc    :
 */
public class BufferExample {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(50);
        charBuffer.put("hello w");
        charBuffer.flip();
        System.out.println(charBuffer.toString());

        char[] chars = new char[10];
        int remaining = charBuffer.remaining();
        System.out.println(remaining);
        charBuffer.get(chars, 0, remaining);
        System.out.println(chars[0]);

    }
}
