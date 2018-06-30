package com.lili.nio.socket;

/**
 * @author lili
 * @date 2018/6/30
 * @description
 */
public class ClientMain {

    public static void main(String[] args) {
        NioSocktClient nioSocktClient = new NioSocktClient("127.0.0.1",8080);
        nioSocktClient.init();
    }
}
