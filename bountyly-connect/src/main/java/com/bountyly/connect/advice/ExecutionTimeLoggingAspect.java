package com.bountyly.connect.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Aspect
@Component
@Slf4j
public class ExecutionTimeLoggingAspect {
    @Pointcut("execution (* com.bountyly.connect.resource.*.*(..))")
    public void resourceClassMethods() {  }

    @Around("resourceClassMethods()")
    public Object logMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object proceedingObject = pjp.proceed();
        long end = System.nanoTime();
        log.info("Execution of " + pjp.getSignature() + " took " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return proceedingObject;
    }
}
