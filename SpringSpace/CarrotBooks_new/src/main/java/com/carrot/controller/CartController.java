package com.carrot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carrot.domain.CartVO;
import com.carrot.domain.MemberVO;
import com.carrot.service.CartService;

@Controller
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	@Autowired private CartService cartService;
	
	@PostMapping("/cart/add")
	public @ResponseBody String addCartPost(CartVO cart, HttpServletRequest req) {
		logger.info("addCartPost 진입");
		
		// 로그인 체크
		HttpSession session = req.getSession();
		System.out.println((MemberVO)session.getAttribute("member"));
		if(session.isNew() || session.getAttribute("member") == null) { // 로그인 중이 아니라면
			return "5";
		}
		
		// 카트 등록
		int result = cartService.addCart(cart);
		
		return String.valueOf(result);	
	}
}
