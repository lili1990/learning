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
public class ClientChannelHandler extends ChannelHandlerAdapter {


    private ByteBuf message;

    public ClientChannelHandler(){
        byte[] bytes = "the clientChannelHandler".getBytes();
        message = Unpooled.buffer(bytes.length);
        message.writeBytes(bytes);
    }


    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception{
        channelHandlerContext.writeAndFlush(message);

    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext,Object msg) throws Exception{
        ByteBuf byteBuf =(ByteBuf)msg;
        byte [] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        String body = new String(bytes,"utf-8");
        System.out.println("the client received message:"+body);

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
