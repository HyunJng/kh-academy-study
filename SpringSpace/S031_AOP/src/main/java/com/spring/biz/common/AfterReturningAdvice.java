package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.user.UserVO;

public class AfterReturningAdvice {

	public void afterLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
	}
	
	// xml에서 returning속성으로 지정된 거을 2번째 파라미터로 넘기라는 의미
	public void afterLog2(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + " 로그인(admin)");
			}
		}
		
		System.out.println("[사후 처리] " + method + "() 메소드 리턴값: " + returnObj.toString());
	}
	
}
