package com.lili.nio.aio;

/**
 * @author lili
 * @date 2018/7/1
 * @description
 */
public class MainServer {

    public static void main(String[] args) {
        AioSocketServer aioSocketServer = new AioSocketServer(9000);
        aioSocketServer.init();
        aioSocketServer.accept();
    }
}
