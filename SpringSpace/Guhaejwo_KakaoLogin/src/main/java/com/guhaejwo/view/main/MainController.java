package com.guhaejwo.view.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/main")
public class MainController {
	
	@GetMapping("/main")
	public String getMainPage() {
		return "main.jsp";
	}
}
