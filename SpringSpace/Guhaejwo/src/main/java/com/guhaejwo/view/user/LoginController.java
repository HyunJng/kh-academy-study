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
	public @ResponseBody Object login(@RequestBody UserDTO user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDTO loginUser = new UserDTO();
		System.out.println("/login Post 실행");
		try {
			loginUser = userService.findById(user);
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
	
	@PostMapping("/login/kakao")
	public @ResponseBody Object kakaoLogin(@RequestBody UserDTO user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDTO loginUser = new UserDTO();
		System.out.println("/login/kakao 실행");
		System.out.println("user정보 확인: " + user.getUserId() + user.getUserEmail() + user.getUserName() + user.getUserImg());
		
		try {
			loginUser = userService.findById(user);
			if(loginUser != null) {	// 로그인 정보가 있다면
				session.setAttribute("user", loginUser);
				return loginUser;
			} else { // 없으면 회원가입
				userService.join_kakao(user);
				session.setAttribute("user", user);
				return user;
			}
		} catch (Exception e) { // 통신오류
			return 9;
		}
	}
	
}
