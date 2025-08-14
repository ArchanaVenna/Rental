package com.wipro.notificationservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LoggingAspect {
	@Before("execution(* com.wipro.notificationservice.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        System.out.println("🔹 Before Method: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.wipro.notificationservice.controller.*.*(..))", returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        System.out.println("✅ After Method: " + joinPoint.getSignature() + " | Returned: " + result);
    }

}
