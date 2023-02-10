package com.dadok.repository;

import com.dadok.domain.MemberVO;

public interface MemberRepository {

	// 회원 저장
	public void save(MemberVO member);
	
	// 회원 email로 검색
	public int emailCheck(MemberVO member);
	
	// 회원찾기(Email)
	public MemberVO findMemberbyEmail(MemberVO member);
}
