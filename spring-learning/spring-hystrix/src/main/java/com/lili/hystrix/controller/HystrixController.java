package com.lili.hystrix.controller;

import com.lili.hystrix.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author lili
 * @date 2018/7/5
 * @description
 *
 *
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @HystrixCommand(
            fallbackMethod = "getFallResult",
            threadPoolProperties = {  //10个核心线程,超过20个的队列外的请求被拒绝; 当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "5"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "5")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"), //命令执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1"), //若干10s一个窗口内失败10次, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
            })
    @RequestMapping(value="/getResult",method = RequestMethod.GET)
    public String getResult(String name){

        return hystrixService.getResult(name);
    }

    public String getFallResult(String name){
        return hystrixService.getFallResult(name);
    }
}
