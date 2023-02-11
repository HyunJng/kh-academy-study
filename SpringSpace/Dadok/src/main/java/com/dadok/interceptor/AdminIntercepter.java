package com.dadok.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dadok.domain.MemberVO;

public class AdminIntercepter implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(AdminIntercepter.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandler 진입");
		/*		
		// admin이면 true, 아니면 false
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member != null && member.getMemberCk().equals("ADMIN")) {
			return true;
		}
		response.sendRedirect("/main");
		
		return false;
		 * */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
