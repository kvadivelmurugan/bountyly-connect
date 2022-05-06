package com.bountyly.connect.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut("within (com.bountyly.connect..*)")
    public void logBeforeAfterMethodCalls () {  }

    @Before("logBeforeAfterMethodCalls()")
    public void logBeforeMethodCall (JoinPoint joinPoint) throws Throwable {
        log.info("Execution of the method {} has begun ", joinPoint.getSignature());
    }

    @After("logBeforeAfterMethodCalls()")
    public void logAfterMethodCall (JoinPoint joinPoint) throws Throwable {
        log.info("Execution of the method {} has ended ", joinPoint.getSignature());
    }
}
