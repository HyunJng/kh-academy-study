package com.dadok.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/main")
	public String mainpageGet() {
		logger.info("메인 페이지 진입");
		return "main";
	}
}
