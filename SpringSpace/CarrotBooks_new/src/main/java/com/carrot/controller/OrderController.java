package com.carrot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderVO;
import com.carrot.service.MemberService;
import com.carrot.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired private OrderService orderService;
	@Autowired private MemberService memberService;
	
	@GetMapping("/{memberId}")
	public String orderPageGet(@PathVariable("memberId") int memberId, OrderVO order, Model model) {
		logger.info("order페이지 진입");
		MemberVO member = new MemberVO();
		member.setMemberId(memberId);
		
		model.addAttribute("orderList", orderService.getGoodsInfo(order.getOrders()));
		model.addAttribute("memberInfo", memberService.findMemberbyId(member));
		return "/order";
	}
}
