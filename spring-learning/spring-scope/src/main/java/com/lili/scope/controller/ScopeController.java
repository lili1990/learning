package com.lili.scope.controller;


import app.context.RuntimeContext;
import com.lili.scope.service.PrototypeScopeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor: lili
 * @Date: 2018/3/29-17:35
 * @Description:
 */
@RestController
@RequestMapping("/service")
public class ScopeController {

    @RequestMapping(value="/scope",method = RequestMethod.GET)
    public void singletonReuest(){
        System.out.println("singletonService===="+RuntimeContext.getBean("singletonService"));
        System.out.println("prototypeScopeService====1====="+RuntimeContext.getBean("prototypeScopeService"));
        System.out.println("prototypeScopeService====2====="+RuntimeContext.getBean("prototypeScopeService"));

    }

    @RequestMapping(value="/requestScope",method = RequestMethod.GET)
    public void requestScope(){
        System.out.println("requestScopeService===="+RuntimeContext.getBean("requestScopeService"));
        System.out.println("sessionScopeService===="+RuntimeContext.getBean("sessionScopeService"));

    }

    @RequestMapping(value="/threadScope",method = RequestMethod.GET)
    public void Scope() throws InterruptedException {
       System.out.println("customerScopeService===="+RuntimeContext.getBean("customerScopeService"));

        // 新建线程
        new Thread(){ public void run() {
            System.out.println("customerScopeService in new Thread ===="+RuntimeContext.getBean("customerScopeService"));
            System.out.println("customerScopeService in new Thread ===="+RuntimeContext.getBean("customerScopeService"));

        }}.start();
        Thread.sleep(1000);

        System.out.println("customerScopeService===="+RuntimeContext.getBean("customerScopeService"));
    }


}
