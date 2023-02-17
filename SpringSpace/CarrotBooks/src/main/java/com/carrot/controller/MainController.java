package com.carrot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carrot.domain.Criteria;
import com.carrot.service.BookService;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private BookService bookService;
	
	public MainController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/main")
	public String mainpageGet(Model model, Criteria cri) {
		logger.info("메인 페이지 진입");
		
		cri.setAmount(8);
		model.addAttribute("newestList", bookService.getBookList(cri));
		
		return "main";
	}
}
