package com.togo.netty.daily.day9;

import com.togo.netty.daily.day7.Packet;

/**
 * @author taiyanan
 */
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
