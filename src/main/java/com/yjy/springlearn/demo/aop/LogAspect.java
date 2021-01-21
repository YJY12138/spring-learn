package com.yjy.springlearn.demo.aop;


import com.yjy.springlearn.demo.annotation.AssertOK;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author youjy
 */
@Component
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.yjy.springlearn.demo.service.*.*(..))")
    public void pointcut1() {

    }

    @Before(value = "pointcut1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "aspect before execute");
    }

    @After(value = "pointcut1() ")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "aspect after execute");
    }

    @AfterReturning(value = "pointcut1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法的返回值为：" + result);
    }

    @AfterThrowing(value = "pointcut1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
    }

    @Around("pointcut1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        //判断注解标识如果不为false则，进行登录
        //先获取被织入增强处理的目标对象，再获取目标类的clazz
        Class<?> aClass = pjp.getTarget().getClass();
        String methodName = pjp.getSignature().getName(); //先获取目标方法的签名，再获取目标方法的名
        logger.info("methodName: " + methodName);  // 输出目标方法名
        Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes(); //获取目标方法参数类型
        Object[] args = pjp.getArgs();  //获取目标方法的入参
        for (int i = 0; i < args.length; i++) {
            logger.info("argsName: " + args[i]); //输出目标方法的参数
        }

        try {
            Method method = aClass.getMethod(methodName, parameterTypes);
            //获取目标方法
            AssertOK annotation = method.getAnnotation(AssertOK.class);
            //获取方法上的注解
            annotation.isLogin();
            //获取注解函数值
            long starttime = System.currentTimeMillis();
            Object proceed = pjp.proceed();
            //执行目标方法
            long exctime = System.currentTimeMillis() - starttime;
            logger.info("执行时间：" + exctime + "毫秒");
            logger.info("proceed: " + proceed);
            //打印目标方法的return结果
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return "aop的返回值";
    }
}
