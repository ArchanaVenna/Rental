package com.wipro.userservice.aop;

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
	@Before("execution(* com.wipro.userservice.controller.UserController.createUser(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("🔹 Before Method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.wipro.userservice.controller.UserController.createUser(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("✅ After Method: " + joinPoint.getSignature().getName() + " | Returned: " + result);
    }

}
