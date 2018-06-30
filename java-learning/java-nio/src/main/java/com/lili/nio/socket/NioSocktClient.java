package com.lili.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class NioSocktClient {

    private static final Logger logger = Logger.getLogger(NioSocketServer.class.getName());


    private Selector selector;

    private SocketChannel socketChannel;

    private String host;

    private int port;

    public NioSocktClient(String host,int port ){
        this.host = host;
        this.port = port;
    }

    public void init(){
        try{
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            connectServer();
        }catch (IOException e){

        }
    }



    public void connectServer(){
        connect();


            try {
                while (true) {
                    selector.select(1000);
                    Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                    Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
                    SelectionKey selectionKey;
                    while (selectionKeyIterator.hasNext()) {
                        selectionKey = selectionKeyIterator.next();
                        handleInput(selectionKey);
                        selectionKeyIterator.remove();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                //多路复用器关闭后，所有注册在selector上的channel和pipe等资源都会被自动注册并关闭，因此不需要释放资源
                if(selector  != null){
                    try {
                        selector.close();
                    } catch (IOException e) {
                        logger.info(String.format(" selector close failed , error msg is %s",e));
                    }
                }
            }

    }


    public void handleInput(SelectionKey selectionKey) throws IOException {
        if(!selectionKey.isValid()){
            logger.info("selectionKey is not valid!  ");
            return ;
        }
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if(selectionKey.isConnectable()) {
            if (socketChannel.finishConnect()) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel, "你好吗？");
            } else {
                System.exit(1);
            }
        }
        if (selectionKey.isReadable()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //异步读取客户端消息到缓冲区
            int readByte = socketChannel.read(byteBuffer);
            if (readByte > 0) {
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                String message = new String(bytes, "utf-8");
                System.out.println("the cleint recieve message :" + message);
                doWrite(socketChannel, "the client has receive message!");
            }
        }

    }

    public void connect(){
        try {
            if(socketChannel.connect(new InetSocketAddress(host,port))){
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel,"你好，我是客户端！");
            }else {
                socketChannel.register(selector,SelectionKey.OP_CONNECT);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    private void doWrite(SocketChannel channel,String response) throws IOException{
        if(response != null && response.trim().length()>0){
            byte[] bytes = response.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            //发送消息到客户端
            channel.write(byteBuffer);
        }
    }
}
