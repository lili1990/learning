package com.lili.nio.aio;


import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class AioSocketClient {

    private String host;

    private int port;

    private AsynchronousSocketChannel asynchronousSocketChannel;

    private CountDownLatch countDownLatch = new CountDownLatch(1);



    public AioSocketClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void init(){
        try{
            asynchronousSocketChannel = AsynchronousSocketChannel.open();
            asynchronousSocketChannel.connect(new InetSocketAddress(host,port),this,new ClientCompletionHandler(asynchronousSocketChannel));

            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
