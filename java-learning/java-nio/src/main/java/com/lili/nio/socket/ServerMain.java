package com.lili.nio.socket;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class ServerMain {

    public static void main(String[] args) {
        NioSocketServer nioSocketServer = new NioSocketServer(8080);
        nioSocketServer.init();

    }
}
