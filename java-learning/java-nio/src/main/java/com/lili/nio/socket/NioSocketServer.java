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
public class NioSocketServer {

    private static final Logger logger = Logger.getLogger(NioSocketServer.class.getName());

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private int port;

    public NioSocketServer(int port){
        this.port = port;
    }

    /**
     *   初始化selector 绑定端口
     */
    public void init(){
        try {
            //创建多路复用器
            selector = Selector.open();
            //打开ServerSocketChannel用于监听客户端的连接，它是所有客户端的父管道
            serverSocketChannel = ServerSocketChannel.open();
            //连接设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            // channel注册到selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            accept();
        }catch (IOException e){
            e.printStackTrace();
            logger.info(String.format(" socket init failed , error msg is %s",e));
        }
    }


    public void accept(){
        try{
            while (true) {
                //selector循环准备就绪的selectionKey
                selector.select();
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
            logger.info(String.format(" socket accpet failed , error msg is %s",e));
        }finally {
            //多路复用器关闭后，所有注册在selector上的channel和pipe等资源都会被自动注册并关闭，因此不需要释放资源
            if(selector  != null){
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
        if(selectionKey.isAcceptable()){
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            //监听到有新的客户端接入
            SocketChannel socketChannel =serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            //将监听到的客户端注册到selector上，监听读操作
            socketChannel.register(selector,SelectionKey.OP_READ);
        }else if(selectionKey.isConnectable()){

        }else if(selectionKey.isReadable()){
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //异步读取客户端消息到缓冲区
            int readByte = socketChannel.read(byteBuffer);
            if(readByte > 0){
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                String message = new String(bytes,"utf-8");
                System.out.println("the server recieve message :"+message);
                doWrite(socketChannel,"the server has receive message!");
            }
        }else if (selectionKey.isWritable()){

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
