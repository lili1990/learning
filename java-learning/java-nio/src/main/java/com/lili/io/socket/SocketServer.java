package com.lili.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author lili
 * @date 2018/6/27
 * @description
 */
public class SocketServer {

    //搭建服务器端
    public static void main(String[] args) throws IOException{
        SocketServer socketService = new SocketServer();
        //创建一个服务器端Socket
        socketService.oneServer();
    }
    public  void oneServer() throws IOException{
        ServerSocket server=null;

        Socket socket=null;

        BufferedReader in =null;
        PrintWriter writer= null;
        BufferedReader br=null;

         Scanner scanner=new Scanner(System.in);
        try{
            try{
                server=new ServerSocket(5209);

                System.out.println("服务器启动成功");

                //2、调用accept()方法开始监听，等待客户端的连接使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
                socket = server.accept();
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer=new PrintWriter(socket.getOutputStream());

                while (true) {
                    //由系统标准输入设备构造BufferedReader对象
                    System.out.println("Client send msg :"+in.readLine());
                    //在标准输出上打印从客户端读入的字符串
                    if(scanner.hasNextLine()) {
                        String sendMsg = scanner.nextLine();
                        System.out.println("server 输出:" + sendMsg);
                        writer.println(sendMsg);
                        writer.flush();
                    }
                }

            }catch(Exception e) {
                System.out.println("没有启动监听："+e);
                //出错，打印出错信息
            }




        }catch(Exception e) {//出错，打印出错信息
            System.out.println("Error."+e);
        }finally {
            if(writer!=null){
                writer.close(); // 关闭Socket输出流
            }
            if(in != null){
                in.close();
            }
            if(socket != null){
                socket.close(); // 关闭Socket
            }
        }
    }



}
