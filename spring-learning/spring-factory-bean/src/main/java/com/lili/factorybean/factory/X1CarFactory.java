package com.lili.factorybean.factory;


import com.lili.factorybean.pojo.Car;
import com.lili.factorybean.pojo.X1Car;

/**
 * @author lili
 * @date 2018/6/22
 * @description
 */
public class X1CarFactory {



    public Car getCar() {
        return new X1Car();
    }
}
