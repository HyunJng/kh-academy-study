package com.guhaejwo.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guhaejwo.biz.user.LoginType;
import com.guhaejwo.biz.user.Role;
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
		return "join";
	}
	
	@PostMapping("/join")
	public String join(UserDTO user) {
		userService.join(user);
		return "login";
	}
	
	@PostMapping("/join/checkId")
	public @ResponseBody Object checkId(@RequestBody UserDTO user) {
		UserDTO existUser;
		existUser = userService.findById(user);
		try {
			if(existUser == null) {
				return 0;
			} else {
				return 1; // 아무거나 넣었음
			}
		} catch (Exception e) {
			return 9;
		}
	}
}
