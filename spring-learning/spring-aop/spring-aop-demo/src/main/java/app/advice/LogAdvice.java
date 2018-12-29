package app.advice;

import app.main.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by lili19289 on 2017/1/22.
 */
public class LogAdvice implements MethodBeforeAdvice,AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Logger.error( "请求方法："+method.getName()+"-----参数为："+ Arrays.toString(objects));
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable{
        Logger.error("返回结果》》》》》"+returnValue);
    }
}
