package app.aspect;

import app.main.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by sdlili on 16-11-15.
 */
@Aspect
public class ExceptionHandleAspect {


    @Around(value="execution(* app.controller..*.*(..))")
    public Object handleException(ProceedingJoinPoint pjp){
        Object reslut = null;

        try{
            reslut=pjp.proceed();
        }catch (Exception e){
            Logger.error("the exception is ",e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            Logger.error("the throwable exception is ",throwable);
        }


        return reslut;
    }

    @AfterThrowing(throwing="ex"
            , pointcut="execution(* app.controller..*.*(..))")
    public void afterThrowing(Throwable e) {
        if (e instanceof RuntimeException) {
            Logger.error("通知中发现异常RuntimeException", e);
        } else {
            Logger.error("通知中发现未知异常", e);
        }
    }
}
