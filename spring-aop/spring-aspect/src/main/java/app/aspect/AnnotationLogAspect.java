package app.aspect;

import app.main.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by lili19289 on 2017/2/9.
 */
@Aspect
@Component
public class AnnotationLogAspect {

    @Pointcut("execution(* app.controller.*.*(..))")
    public void aop(){

    }

    @Around("aop()")
    public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        // 在Spring的环境里，signature就是MethodSignature
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取Method
        Method method = methodSignature.getMethod();
        String rquestInfo="";
        Logger.error(rquestInfo + "注释切面请求方法："+method.getName()+"-----参数为："+ Arrays.toString(pjp.getArgs()));
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = pjp.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            Logger.error(result + " >>>>>>>> spend time " + (endTime - startTime) + " millis ");
        }
        return result;

    }
}
