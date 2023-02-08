package com.dadok.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dadok.domain.MemberVO;
import com.dadok.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/join")
	public String joinGet() {
		logger.info("회원가입 페이지 진입");
		return "/member/join";
	}
	
	@GetMapping("/login")
	public String loginGet() {
		logger.info("로그인 페이지 진입");
		return "/member/login";
	}
	
	@PostMapping("/join")
	public String joinPost(MemberVO member) {
		logger.info("join 진입");
		
		memberService.join(member);
		
		logger.info("join service 성공");
		return "redirect: main";
	}
	
	@PostMapping("/memberEmailChk")
	public @ResponseBody String memberEmailChkPost(MemberVO member) {
		logger.info("memberEmailChk 진입, 검색 emailL: " + member.getMemberEmail());
		
		int result = memberService.countMemberbyEmail(member);
		logger.info("멤버 존재 결과값 : " + result);
		
		if(result != 0)
			return "fail";
		else
			return "success";
	}
	
}
