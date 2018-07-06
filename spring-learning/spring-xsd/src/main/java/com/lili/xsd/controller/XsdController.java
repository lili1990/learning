package com.lili.xsd.controller;

import com.lili.xsd.bean.NettyRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lili
 * @date 2018/7/5
 * @description
 */
@RestController
public class XsdController {

    @Autowired
    private NettyRpc nettyRpc;

    @RequestMapping("/getProp")
    public String getProp(){
        return nettyRpc.getHost();
    }
}
