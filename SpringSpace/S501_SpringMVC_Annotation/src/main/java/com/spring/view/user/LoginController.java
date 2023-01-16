package com.spring.view.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;


@Controller
public class LoginController {

	// 1. @RequestMapping의 default method는 "GET"방식
	// 		-parameter로 구체적인 method 지정 가능
	// 		loginView 메소드의 parameter인 vo 객체가 자동으로 login.jsp에도 전달 가능하다.
	// 		-> jsp같은 경우는 request, page, session, application내장 객체를 사용하여 뎅이터를 jsp에 전달해얗나다.
	// 2. @ModelAttribute란?
	// 		- "login.jsp에 전달되는 객체"의 이름은 기본으로 class의 이름으로 자동 만들어진다.(UserVo class이기 때문에 jsp에는 userVO이름으로 사용 가능)
	//		- 지금은 객체 이름을 user로 생성해 준 것이다.
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {

		System.out.println("로그인 화면으로 이동");
		vo.setId("1111");
		vo.setPassword("1234");
		return "login.jsp";
	}

	// Session도 자동 생성된다.
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {

		System.out.println("로그인 인증 처리 ...");
		
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}

		UserVO user = userDAO.getUser(vo);
		if (userDAO.getUser(vo) != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

}
