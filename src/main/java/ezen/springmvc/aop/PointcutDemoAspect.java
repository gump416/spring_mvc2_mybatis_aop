package ezen.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Component
@Aspect
@Slf4j
public class PointcutDemoAspect {
	/**
	 * Pointcut 종류
	 * : @Before(), @After(), @AfterReturnning(), @AfterThrowing(), @Around()
	 */
	@Before("execution(* ezen.springmvc..*(..))")
	public void beforeLog() {
		log.info("===== 비즈니스 메소드 실행 이전 =====");
	}
	@After("execution(* ezen.springmvc..*(..))")
	public void afterLog() {
		log.info("===== 비즈니스 메소드 실행 이후 =====");
	}
	@AfterReturning(pointcut = "execution(* ezen.springmvc..*(..))", returning = "returnValue")
	public void afterReturningLog(JoinPoint joinPoint, Object returnValue) {
		log.info(">> 비즈니스 메소드 반환값: {}", returnValue);
	}
	@AfterThrowing(pointcut = "execution(* ezen.springmvc..*(..))", throwing = "exception")
	public void afterThrowingLog(JoinPoint joinPoint, Throwable exception) {
		log.info(">> {} 메소드 예외발생 : {}" ,joinPoint.getSignature().toShortString() , exception);
	}
	@Around("execution(* ezen.springmvc..*(..))")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String bizObject = joinPoint.getTarget().getClass().getName();
		String bizMethod = joinPoint.getSignature().toShortString();
		log.info("＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠＠");
		try {
			return joinPoint.proceed();
		}finally {
			log.info("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
		}
	}
}



