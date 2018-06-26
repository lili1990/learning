package com.lili.factorybean.controller;

import com.lili.factorybean.pojo.Car;
import com.lili.factorybean.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lili
 * @date 2018/6/22
 * @description Spring的factory-method和factory-bean使用
 */
@RestController
@RequestMapping("/service")
public class FactoryBeanController {


    private Car x1Car;
    private Car x3Car;



    @RequestMapping("/test")
    public String testCar(){
        System.out.println("x1Car---"+x1Car.toString());
        System.out.println("x3Car---"+x3Car.toString());
        return "success";
    }


    public Car getX1Car() {
        return x1Car;
    }

    public void setX1Car(Car x1Car) {
        this.x1Car = x1Car;
    }

    public Car getX3Car() {
        return x3Car;
    }

    public void setX3Car(Car x3Car) {
        this.x3Car = x3Car;
    }
}
