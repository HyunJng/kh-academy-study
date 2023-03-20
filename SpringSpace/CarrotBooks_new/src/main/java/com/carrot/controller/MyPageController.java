package com.carrot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carrot.domain.Criteria;
import com.carrot.domain.MemberInfoVO;
import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderCancleVO;
import com.carrot.domain.OrderVO;
import com.carrot.domain.ReplyPageVO;
import com.carrot.service.OrderService;
import com.carrot.service.ReplyService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	Logger logger = LoggerFactory.getLogger(MyPageController.class);
	@Autowired ReplyService replyService;
	@Autowired OrderService orderService;
	
	// 마이페이지
	@GetMapping("/main")
	public String myPageGet() {
		return "/mypage/main";
	}
	
	// 내가작성한댓글 페이지
	@GetMapping("/myreply/{memberId}")
	public String myReplyPageGet(Model model, Criteria cri, @PathVariable("memberId") String memberId) {
		logger.info("mypage Reply 페이지 진입");
		cri.setKeyword(memberId);
		cri.setAmount(4);
		
		ReplyPageVO reply = replyService.getReplyListByMemberId(cri);
		if(reply != null) {
			model.addAttribute("reply", reply);
		} else {
			model.addAttribute("replyChk", "empty");
		}
		return "/mypage/myreply";
	}
	
	// 댓글 검색 (memberId)
	@GetMapping("/getreply")
	public @ResponseBody ReplyPageVO getMyReply(Criteria cri) {
		logger.info("getMyReply 진입");
		cri.setAmount(2);
		
		ReplyPageVO result = replyService.getReplyListByMemberId(cri);
		
		return result;
	}
	
	// 주문 내역 페이지 진입
	@GetMapping("/orderlist/{memberId}")
	public String getorderList(Criteria cri, @PathVariable("memberId") String memberId, Model model) {
		logger.info("myorder 페이지 진입");
		
		cri.setKeyword(String.valueOf(memberId));
		List<OrderVO> list = orderService.getOrderList(cri); 
	
		if(!list.isEmpty()) {
			model.addAttribute("orderList", list);
			model.addAttribute("pageMaker", orderService.getOrderPageMaker(cri));
		} else {
			model.addAttribute("orderListCheck", "empty");
		}
		
		return "/mypage/myorder";
	}
	
	// 주문 취소
	@PostMapping("/orderCancle")
	public String orderCanclePost(OrderCancleVO vo) {
		logger.info("orderCanclePost 진입");
		
		orderService.orderCancle(vo);
		return "redirect:/mypage/orderlist/" + vo.getKeyword();
	}
}
