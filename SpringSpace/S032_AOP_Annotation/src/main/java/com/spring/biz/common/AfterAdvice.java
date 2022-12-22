package com.spring.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@After("PointCutCommon.allPointCut()")
	public void finallyLog() {
		System.out.println("[사후 처리] 비즈니스 로직수행 후 무조건 실행");
	}
}
