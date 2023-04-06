package ezen.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 시간 측정 공통 기능(Advice)과 공통 기능을 적용할 Pointcut(공통기능을 적용하는 조건) 정의
 * 하나 이상의 Advice와 Pointcut 정의 가능 
 */
@Slf4j
//@Component
@Aspect
public class TimeTraceAspect {
	
	// 공통 기능을 적용할 Pointcut 정의(비즈니스 메소드 실행 전과 후에 실행)
	@Around("execution(* ezen.springmvc..*(..))")
	// 시간 체크 및 로그 기록 공통 기능
	public Object executeTimeTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		String bizObject = joinPoint.getTarget().getClass().getName();
		String bizMethod = joinPoint.getSignature().toShortString();
		log.info("--------- {} 객체의 {} 메소드 실행 ------------", bizObject, bizMethod);
		try {
			return joinPoint.proceed();// 실제 비즈니스객체의 메소드 호출
		}finally {
			long finish = System.currentTimeMillis();
			long excuteTime = finish - start;
			log.info("- {} 메소드 실행 시간 : {}", bizMethod, excuteTime);
			log.info("--------- {} 객체의 {} 메소드 종료 ------------", bizObject, bizMethod);
		}
	}
}





