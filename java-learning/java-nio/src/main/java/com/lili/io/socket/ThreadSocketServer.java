package com.lili.io.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author lili
 * @date 2018/6/28
 * @description
 */
public class ThreadSocketServer implements Runnable{

    private Socket socket;

    public ThreadSocketServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try{
            bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter=new PrintWriter(socket.getOutputStream());
            System.out.println("Client send msg :"+bufferedReader.readLine()+"---"+Thread.currentThread().getId());
            //必须要及时关闭，因为readline这个方法是以\r\n作为界定符的，
            // 由于发送消息的那一端用的是PrintWriter的write()方法，这个方法并没加上\r\n,所以会一直等待

            printWriter.write("server 收到消息");
            printWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
                if (printWriter!=null) {
                    printWriter.close();
                }
                try {
                    if (bufferedReader!=null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

    }



}
