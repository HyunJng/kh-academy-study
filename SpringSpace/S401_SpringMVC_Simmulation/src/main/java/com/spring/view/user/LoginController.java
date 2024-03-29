package com.spring.view.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;
import com.spring.view.controller.Controller;

public class LoginController implements Controller{
       
    public LoginController() {
        
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	
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
		
		// 3. 화면 navigation
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login";
		}

    }
}
