package com.lili.nio.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AioSocketServer> {

    @Override
    public void completed(AsynchronousSocketChannel asynchronousSocketChannel, AioSocketServer aioSocketServer) {
        aioSocketServer.asynchronousServerSocketChannel.accept(aioSocketServer,this);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        asynchronousSocketChannel.read(byteBuffer,byteBuffer,new ReadCompletionHandler(asynchronousSocketChannel));
    }

    @Override
    public void failed(Throwable exc, AioSocketServer attachment) {
        exc.printStackTrace();
    }

}
