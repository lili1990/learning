package app.aspect.aspects;

import app.main.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by sdlili on 16-11-15.
 */
public class ExceptionHandleAspect {


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
}
