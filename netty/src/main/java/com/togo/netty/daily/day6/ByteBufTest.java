package com.togo.netty.daily.day6;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author taiyanan
 */
public class ByteBufTest {

    public static void main(String[] args) {

        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        print("source", buffer);
        buffer.writeInt(123);
        print("writeInt 123", buffer);
        buffer.writeInt(222);
        print("writeInt 222", buffer);
        ByteBuf tar = ByteBufAllocator.DEFAULT.buffer(9, 100);
        tar.writeBytes(buffer);
        print("write tar", buffer);
        print("wr", tar);
        tar.readBytes(buffer);
        print("write tar1", buffer);
        print("wr1", tar);
    }

    private static void print(String action, ByteBuf buffer) {
        System.out.println("after ===========" + action + "============");
        System.out.println("capacity(): " + buffer.capacity());
        System.out.println("maxCapacity(): " + buffer.maxCapacity());
        System.out.println("readerIndex(): " + buffer.readerIndex());
        System.out.println("readableBytes(): " + buffer.readableBytes());
        System.out.println("isReadable(): " + buffer.isReadable());
        System.out.println("writerIndex(): " + buffer.writerIndex());
        System.out.println("writableBytes(): " + buffer.writableBytes());
        System.out.println("isWritable(): " + buffer.isWritable());
        System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());
        System.out.println();
    }
}
