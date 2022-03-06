package com.togo.netty.daily.day3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author taiyanan
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + " : client");

    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {

        ByteBuf buffer = ctx.alloc().buffer();

        return buffer;
    }
}
