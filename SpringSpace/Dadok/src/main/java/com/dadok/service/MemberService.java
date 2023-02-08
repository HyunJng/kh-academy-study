package com.dadok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dadok.domain.MemberVO;
import com.dadok.repository.MemberRepository;

@Service("memberService")
public class MemberService {

	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public void join(MemberVO member) {
		memberRepository.save(member);
	}
	
	public int countMemberbyEmail(MemberVO member) {
		int exist = memberRepository.emailCheck(member);
		
		if(exist != 0) {
			return 1;	// 중복 아이디 존재 O
		} else
			return 0; // 중복 아이디 존재 X
	}
}
