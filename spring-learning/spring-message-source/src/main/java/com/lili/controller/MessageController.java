package com.lili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by lili19289 on 2017/3/10.
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageSource msg;

    @RequestMapping(value="/index", method = {RequestMethod.GET},produces="application/json;charset=utf-8")
    public String test(HttpServletRequest request, HttpServletResponse response){
        //从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        response.setContentType("application/json;charset=utf-8");
        System.out.println(msg.getMessage("desc", new Object[]{}, Locale.CHINA));
        System.out.println(msg.getMessage("desc", new Object[]{}, Locale.US));
        return requestContext.getMessage("desc");
    }
}
