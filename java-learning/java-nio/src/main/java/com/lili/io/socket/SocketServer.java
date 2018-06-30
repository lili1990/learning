package com.lili.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author lili
 * @date 2018/6/27
 * @description
 */
public class SocketServer {


    //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
    private static ExecutorService threadPool = new ThreadPoolExecutor(5,10,60, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(100));

    //搭建服务器端
    public static void main(String[] args) throws IOException{
        SocketServer socketService = new SocketServer();
        //创建一个服务器端Socket
        socketService.oneServer();
    }
    public  void oneServer() throws IOException{
        Socket socket=null;
        try{
            try{
                ServerSocket server=new ServerSocket(5209);
                System.out.println("服务器启动成功");

                while (true) {
                    socket = server.accept();
                    threadPool.execute(new ThreadSocketServer(socket));
                }

            }catch(Exception e) {
                System.out.println("没有启动监听："+e);
                //出错，打印出错信息
            }

        }catch(Exception e) {//出错，打印出错信息
            System.out.println("Error."+e);
        }finally {
            if(socket != null){
                socket.close(); // 关闭Socket
            }
        }
    }



}
