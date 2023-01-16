package com.spring.view.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

public class LoginController implements Controller{
       
    public LoginController() {
        
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	
    	System.out.println("로그인 처리");
    	
    	// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		// 3. 화면 navigation
		if (user != null) {
			// redirect: estViewName(viewResolver일: prefix, suffix붙이는 동작)이 동작하지 않도록 하기 위해 
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		
		return mav;

    }
}
