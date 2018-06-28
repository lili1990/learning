package com.lili.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * @author lili
 * @date 2018/6/27
 * @description
 */
public class SocketClient {

    // 搭建客户端
    public static void main(String[] args) throws IOException {

        Socket socket = null;

        PrintWriter write = null;

        BufferedReader in = null;

        Scanner scanner = null;
        try {

            socket = new Socket("127.0.0.1", 5209);
            System.out.println("客户端启动成功");

            scanner = new Scanner(System.in);

            // 由系统标准输入设备构造BufferedReader对象
            write = new PrintWriter(socket.getOutputStream());
            // 由Socket对象得到输出流，并构造PrintWriter对象
            //3、获取输入流，并读取服务器端的响应信息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 由Socket对象得到输入流，并构造相应的BufferedReader对象

            while (true ){

                // 判断是否还有输入
                if (scanner.hasNextLine()) {
                    String msg = scanner.nextLine();
                    System.out.println("输入的数据为：" + msg);
                    write.println(msg);
                    write.flush();
                }
                String reciverMsg = in.readLine();
                if(reciverMsg!="" && reciverMsg != null) {
                    System.out.println(" server send msg " + reciverMsg);
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(write!=null){
                write.close(); // 关闭Socket输出流
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
