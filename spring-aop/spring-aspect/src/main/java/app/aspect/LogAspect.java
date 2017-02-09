package app.aspect;

import app.main.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by lili19289 on 2017/2/9.
 */
public class LogAspect {

    public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        // 在Spring的环境里，signature就是MethodSignature
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 获取Method
        Method method = methodSignature.getMethod();
        String rquestInfo="";
        Logger.error(rquestInfo + "请求方法："+method.getName()+"-----参数为："+ Arrays.toString(pjp.getArgs()));
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
