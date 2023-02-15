package com.dadok.repository;

import java.util.List;

import com.dadok.domain.Criteria;
import com.dadok.domain.MemberVO;

public interface MemberRepository {

	// 회원 저장
	public void save(MemberVO member);
	
	// 회원 email로 검색
	public int emailCheck(MemberVO member);
	
	// 회원찾기(Email)
	public MemberVO findMemberbyEmail(MemberVO member);
	
	// 회원 목록 검색
	public List<MemberVO> getMemberList(Criteria cri);
	
	// 회원 전체 수 검색
	public int getTotal();
	
}