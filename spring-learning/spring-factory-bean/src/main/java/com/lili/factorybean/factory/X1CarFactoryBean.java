package com.lili.factorybean.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author lili
 * @date 2018/6/22
 * @description
 */
public class X1CarFactoryBean implements FactoryBean{



    @Override
    public Object getObject() throws Exception {
        return new X1CarFactory();
    }

    @Override
    public Class<?> getObjectType() {
        return X1CarFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
