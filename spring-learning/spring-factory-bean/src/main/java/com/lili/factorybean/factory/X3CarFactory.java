package com.lili.factorybean.factory;

import com.lili.factorybean.pojo.Car;
import com.lili.factorybean.pojo.X3Car;

/**
 * @author lili
 * @date 2018/6/22
 * @description
 */
public class X3CarFactory {


    public static Car getCar(){
        return new X3Car();
    }

}
