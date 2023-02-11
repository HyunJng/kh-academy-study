package com.dadok.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/main")
	public String adminMainGet() {
		logger.info("관리자 페이지 진입");
		return "/admin/main";
	}
	
	@GetMapping("/addGoods")
	public String addGoodsGet() {
		logger.info("상품 등록 페이지 진입");
		return "/admin/addGoods";
	}

	@GetMapping("/manageGoods")
	public String manageGoodsGet() {
		logger.info("상품 관리 페이지 진입");
		return "/admin/manageGoods";
	}
	
}
