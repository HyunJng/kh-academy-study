package com.guhaejwo.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guhaejwo.biz.user.UserDTO;
import com.guhaejwo.biz.user.impl.UserService;

@Controller
//@RequestMapping("/login")
public class LoginController {

	private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	// 로그인 페이지 이동
	@GetMapping("/login")
	public String getLoginForm() {
		return "login.jsp";
	}
	
	// 로그인 기능
	@PostMapping("/login")
	public @ResponseBody Object Login(@RequestBody UserDTO user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDTO loginUser = new UserDTO();
		System.out.println("/login Post 실행");
		try {
			loginUser = userService.findById(user);
			System.out.println("아이디비교: " + loginUser.getUserId() + " " + user.getUserId());
			System.out.println("비밀번호비교: " + loginUser.getUserPw() + " " + user.getUserPw());
			System.out.println((loginUser.getUserPw().equals(user.getUserPw()) ));
			if(loginUser != null && (loginUser.getUserPw()).equals(user.getUserPw())) {	// 성공
				session.setAttribute("user", loginUser);
				return loginUser;
			} else {
				return 0; // 없을 때
			}
		} catch (Exception e) { // 통신오류
			return 9;
		}
	}
	
}
