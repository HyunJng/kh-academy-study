package com.guhaejwo.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guhaejwo.biz.user.UserDTO;
import com.guhaejwo.biz.user.impl.UserService;

@Controller
public class JoinController {

	private final UserService userService;
	
	@Autowired
	public JoinController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/join")
	public String getJoinPage() {
		return "join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@RequestBody UserDTO user) {
		userService.join(user);
		return "login.jsp";
	}
}
