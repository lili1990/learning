package com.lili.nio.aio;

/**
 * @author lili
 * @date 2018/7/1
 * @description
 */
public class MainClient {

    public static void main(String[] args) {
        AioSocketClient aioSocketClient = new AioSocketClient("127.0.0.1",9000);
        aioSocketClient.init();
    }
}
