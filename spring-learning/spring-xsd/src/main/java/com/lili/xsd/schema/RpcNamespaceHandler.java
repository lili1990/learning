package com.lili.xsd.schema;

import com.lili.xsd.bean.NettyRpc;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author lili
 * @date 2018/7/5
 * @description
 */
public class RpcNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        registerBeanDefinitionParser("element", new RpcBeanDefinitionParser(NettyRpc.class));

    }
}
