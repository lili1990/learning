package app.aspect.aspects;

import app.aspect.annotation.SaveLog;
import app.main.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 该切面作用于Controller，记录请求的方法以及参数；要用around方式
 * Created by lili19289 on 2016/9/21.
 */
public class LogAspect {


    public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        // 在Spring的环境里，signature就是MethodSignature
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取Method
        Method method = methodSignature.getMethod();
        String rquestInfo="";
        if(method.isAnnotationPresent(SaveLog.class)){
            rquestInfo+="操作为："+method.getAnnotation(SaveLog.class).value();
        }
        Logger.error(rquestInfo + "请求方法："+method.getName()+"-----参数为："+Arrays.toString(pjp.getArgs()));
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
