package com.togo.nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author : taiyn
 * Date    : 2021/3/1
 * Time    : 9:01 上午
 * ---------------------------------------
 * Desc    :
 */
public class ChannelCopyExample {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("in.txt");
        ReadableByteChannel readableByteChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
        WritableByteChannel writableByteChannel = fileOutputStream.getChannel();

        copyData(readableByteChannel, writableByteChannel);

        readableByteChannel.close();
        writableByteChannel.close();
    }

    private static void copyData(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1 * 1024);
        while (readableByteChannel.read(buffer) != -1) {

            buffer.flip();

            while (buffer.hasRemaining()) {
                writableByteChannel.write(buffer);
            }

            buffer.clear();
        }
    }
}
