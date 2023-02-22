package com.carrot.controller;


import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carrot.domain.AttachImageVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.service.AdvertService;
import com.carrot.service.BookService;
import com.carrot.service.ImageService;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private BookService bookService;
	private ImageService imageService;
	
	@Autowired
	public MainController(BookService bookService, ImageService imageService) {
		this.bookService = bookService;
		this.imageService = imageService;
	}
	
	@GetMapping("/main")
	public String mainpageGet(Model model, Criteria cri) {
		logger.info("메인 페이지 진입");
		cri.setAmount(8);
		
		model.addAttribute("newestList", bookService.getBookList(cri));
		model.addAttribute("advertList", imageService.getImageList());
		model.addAttribute("cateList", bookService.getCateList());
		return "/main";
	}
	
	@GetMapping("/main/search")
	public String searchGet(Criteria cri, Model model) {
		logger.info("search페이지 진입");
		
		cri.setAmount(5);
		List<BookVO> list = bookService.getBookList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("bookList", list);
		} else {
			model.addAttribute("bookListChk", "empty");
		}
		
		model.addAttribute("pageMaker", bookService.getBookPageMaker(cri));
		return "/search";
	}

	
}
