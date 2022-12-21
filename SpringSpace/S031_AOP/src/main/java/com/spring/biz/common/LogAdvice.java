package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {

	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
	
	// JoinPoint interface 안에 선언된 method 사용 가능
	public void printLog2(JoinPoint jp) {
		String method = jp.getSignature().getName(); // method이름 가져옴
		Object[] args = jp.getArgs();	// parameter 가져옴
		System.out.println("[사전 처리] "+method + "() 메소드 Args 정보: " + args[0].toString());
	}
}
