package com.example.test.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

public class LoggingAspect {
    @Around("execution(* com.example.controller.UserController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @Before("execution(* com.example.controller.UserController.*(..))")
    public void logInputs() {
        System.out.println("Input received");
    }

    @After("execution(* com.example.controller.UserController.*(..))")
    public void logOutputs() {
        System.out.println("Output sent");
    }
}
