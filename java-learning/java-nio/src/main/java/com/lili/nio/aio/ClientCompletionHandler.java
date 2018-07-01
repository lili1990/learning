package com.lili.nio.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author lili
 * @date 2018/7/1
 * @description
 */
public class ClientCompletionHandler implements CompletionHandler<Void,AioSocketClient> {


    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ClientCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel){
        this.asynchronousSocketChannel = asynchronousSocketChannel;
    }

    @Override
    public void completed(Void result, AioSocketClient attachment) {
        byte [] bytes = "你好，服务器！".getBytes();
        final ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        asynchronousSocketChannel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(attachment.hasRemaining()){
                    asynchronousSocketChannel.write(attachment,attachment,this);
                }else {
                    ByteBuffer readBuffer  = ByteBuffer.allocate(1024);
                    asynchronousSocketChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bytes = new byte[attachment.remaining()];
                            attachment.get(bytes);
                            try {
                                String message = new String(bytes,"utf-8");
                                System.out.println(" -------message----"+message);
                            }catch (IOException e){
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                            try{
                                asynchronousSocketChannel.close();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
                try{
                    asynchronousSocketChannel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void failed(Throwable exc, AioSocketClient attachment) {
        exc.printStackTrace();
        try{
            asynchronousSocketChannel.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
