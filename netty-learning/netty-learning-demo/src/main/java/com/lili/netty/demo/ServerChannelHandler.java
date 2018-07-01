package com.lili.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;



/**
 * @author lili
 * @date 2018/7/1
 * @description
 */
public class ServerChannelHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext,Object msg) throws Exception{
        ByteBuf byteBuf =(ByteBuf)msg;
        byte [] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        String body = new String(bytes,"utf-8");
        System.out.println("the server received message:"+body);

        ByteBuf responseBuf = Unpooled.copiedBuffer("I have receive the message".getBytes());

        channelHandlerContext.write(responseBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
