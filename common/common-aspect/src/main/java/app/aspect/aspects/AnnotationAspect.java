package app.aspect.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lili19289 on 2017/2/8.
 */
@Aspect
public class AnnotationAspect {

    /**
     * 声明切入点表达式，一般在该方法中不再添加其他代码。
     * 使用@Pointcut来声明切入点表达式。
     * 后面的通知直接使用方法名来引用当前的切入点表达式。
     */
    @Pointcut("execution(*app.*.*(..))")
    public void declareJoinPointExpression() {}

    /**
     *前置通知，在目标方法开始之前执行。
     *@Before("execution(public int com.spring.aop.impl.ArithmeticCalculator.add(int, int))")这样写可以指定特定的方法。
     * @param joinpoint
     */
    @Before("declareJoinPointExpression()")
    //这里使用切入点表达式即可。后面的可以都改成切入点表达式。如果这个切入点表达式在别的包中，在前面加上包名和类名即可。
    public void beforeMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinpoint.getArgs());
        System.out.println("前置通知：The method "+ methodName +" begins with " + args);
    }



}
