package com.book.aop.service.aspect;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.book.aop.service.BookService.*(..))")
	public void logBefore(JoinPoint jp) {
		logger.info("Before method: " + jp.getSignature());
	}
	
	@After("execution(* com.book.aop.service.BookService.*(..))")
	public void logAfter(JoinPoint jp) {
		logger.info("After method: "+ jp.getSignature());
	}
	@AfterThrowing(
			value = "execution(* com.book.aop.service.BookService.*(..))",
			throwing = "ex"
			)
	public void logException(Exception ex) {
		logger.error("Exception thrown: "+ ex.getMessage());
	}
	@AfterReturning(
			value = "execution(* com.book.aop.service.BookService.*(..))",
			returning = "result"
			)
	public void logReturn(Object result) {
		logger.info("Method returned: "+ result);
	}
	
	@Around("execution(* com.book.aop.service.BookService.*(..))")
	public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		long end = System.currentTimeMillis();
		
		logger.info("Execution time of "+pjp.getSignature() + " is: " + (end-start) + " ms");
		
		return result;
	}
	
	
}
