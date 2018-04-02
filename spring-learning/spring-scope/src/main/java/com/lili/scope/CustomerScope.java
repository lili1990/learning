package com.lili.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @Autor: lili
 * @Date: 2018/3/30-14:56
 * @Description: 自定义scope，作用范围同一个Thread
 */
public class CustomerScope implements Scope{

    private static final ThreadLocal<Map<String,Object>> THREAD_BEAN_MAP = new ThreadLocal<Map<String, Object>>(){
        //初始化自定义上下文数据
        protected Map<String,Object> initialValue(){
            return new HashMap<>();
        }
    };
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        Map<String,Object> beanMap = THREAD_BEAN_MAP.get();
        if(!beanMap.containsKey(name)){
            beanMap.put(name,objectFactory.getObject());
        }
        return beanMap.get(name);
    }

    @Override
    public Object remove(String name) {
        Map<String,Object> beanMap = THREAD_BEAN_MAP.get();
        return beanMap.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
