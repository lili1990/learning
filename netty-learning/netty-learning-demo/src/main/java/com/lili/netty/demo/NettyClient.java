package com.lili.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author lili
 * @date 2018/7/1
 * @description
 */
public class NettyClient {

    public static void main(String[] args) throws Exception{
        NettyClient nettyClient = new NettyClient();
        nettyClient.connect("127.0.0.1",9000);
    }

    public void connect(String host,int port) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap  = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                     .channel(NioSocketChannel.class)
                     .option(ChannelOption.TCP_NODELAY,true)
                     .handler(new ChildChannelHandler());
            //异步连接操作
            ChannelFuture future = bootstrap.connect(host,port).sync();

            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        }catch (Exception e){

        }
    }


    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel )throws Exception{
            socketChannel.pipeline().addLast(new ClientChannelHandler());
        }
    }
}
