package app.aspect;

import app.main.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.ThrowsAdvice;

/**
 * Created by lili19289 on 2016/11/16.
 */
public class ExceptionHandler implements ThrowsAdvice {

    public Object handleException(ProceedingJoinPoint pjp){
        Logger.debug("exception 来了！");
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


    public void afterThrowing(Exception e) throws Throwable {
        Logger.debug("exception 来了！");
    }

}
