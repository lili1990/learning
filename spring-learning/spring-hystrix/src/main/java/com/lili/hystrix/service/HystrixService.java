package com.lili.hystrix.service;

/**
 * @author lili
 * @date 2018/7/5
 * @description
 */
public interface HystrixService {


    String getResult(String name);

    String getFallResult(String name);
}
