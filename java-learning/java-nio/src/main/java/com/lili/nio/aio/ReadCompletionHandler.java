package com.lili.nio.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer> {

    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel){
        this.asynchronousSocketChannel = asynchronousSocketChannel;
    }


    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte [] bytes = new byte[attachment.remaining()];
        attachment.get(bytes);
        write("I receive the message");
        try{
            String message = new String(bytes,"utf-8");
            System.out.println("the server receive message :"+message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try{
            asynchronousSocketChannel.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void write(String message){

        final ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
        byteBuffer.put(message.getBytes());
        byteBuffer.flip();
        asynchronousSocketChannel.write(byteBuffer,byteBuffer, new CompletionHandler<Integer,ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(byteBuffer.hasRemaining()){
                    asynchronousSocketChannel.write(byteBuffer,byteBuffer,this);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try{
                    asynchronousSocketChannel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
