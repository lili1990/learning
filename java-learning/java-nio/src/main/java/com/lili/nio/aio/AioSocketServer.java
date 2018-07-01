package com.lili.nio.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class AioSocketServer {

    private int port;

    protected AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public AioSocketServer(int port){
        this.port = port;
    }

    public void init(){
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("AioSocketServer start sucess,in port "+port);
        }catch (IOException e){
            System.out.println("AioSocketServer start failed,in port "+port);
            e.printStackTrace();
        }
    }

    public void accept(){
        try{
//            while (true) {
                //AcceptCompletionHandler接受accpet成功后的通知消息
                asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
                countDownLatch.await();
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
