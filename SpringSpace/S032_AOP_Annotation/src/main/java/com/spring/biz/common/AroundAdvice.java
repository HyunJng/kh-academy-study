package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] 비즈니스 메소드 수행 전에 처리할 내용");
		// proceed() : 원래 method의 내용을 실행하라는 메소드
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER] 비즈니스 메소드 수행 후에 처리할 내용");
		
		return returnObj;
	}
	
	@Around("PointCutCommon.allPointCut()")
	public Object aroundLog2(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
}
