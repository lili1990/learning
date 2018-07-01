package com.lili.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author lili
 * @date 2018/7/1
 * @description
 */
public class NettyServer {


    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.bind(9000);
    }

    public void  bind(int port){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup =new NioEventLoopGroup();

        try{

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(eventLoopGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());
            //绑定端口，同步等待成功
            ChannelFuture future = bootstrap.bind(port).sync();
            //等待服务器端口关闭
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel )throws Exception{
            socketChannel.pipeline().addLast(new ServerChannelHandler());
        }
    }
}
