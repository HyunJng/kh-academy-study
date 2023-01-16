package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 빈으로 생성
@Aspect // aspect ref 와 동일한 기능
public class LogAdvice {
	
//	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
//	public void allPointCut() {}
	
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}

	@Before("PointCutCommon.allPointCut()") // pointCut + AOP형태 결정 
	public void printLog2(JoinPoint jp) {
		String method = jp.getSignature().getName(); // method이름 가져옴
		Object[] args = jp.getArgs();	// parameter 가져옴
		System.out.println("[사전 처리] "+method + "() 메소드 Args 정보: " + args[0].toString());
	}
}
