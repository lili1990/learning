package com.lili.hystrix.service;

import org.springframework.stereotype.Service;

/**
 * @author lili
 * @date 2018/7/5
 * @description
 */
@Service("hystrixService")
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String getResult(String name) {
//        throw new RuntimeException("测试");
        return String.format("normal interface,%s",name);
    }

    @Override
    public String getFallResult(String name) {
        return String.format("hystrix interface,%s",name);
    }
}
